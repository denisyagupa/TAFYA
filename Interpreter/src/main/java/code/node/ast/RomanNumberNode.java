package code.node.ast;

import code.tokens.Token;

public class RomanNumberNode extends ExpressionNode {

    public final Token romenumber;
    private int num;   // The number represented by this Roman numeral.
    private String roman;

    public RomanNumberNode(Token romenumber) {
        this.romenumber = romenumber;
        num = 0;
        roman = romenumber.text;
    }



    @Override
    public String toString() {
        return romenumber.text;
    }

    private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,
            50,   40,   10,    9,    5,    4,    1 };

    private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
            "L",  "XL",  "X",  "IX", "V",  "IV", "I" };



    public int toInt(String roman) {

        if (roman.length() == 0)
            throw new NumberFormatException("An empty string does not define a Roman numeral.");

        roman = roman.toUpperCase();  // Convert to upper case letters.

        int i = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);
            int number = letterToNumber(letter);

            if (number < 0)
                throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

            i++;

            if (i == roman.length()) {
                arabic += number;
            }
            else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    arabic += number;
                }
            }

        }

        return num = arabic;

    }


    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }

}

