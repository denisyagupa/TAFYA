package code.tokens;

import java.util.regex.Pattern;

public enum TokenType {
    NUMBER("[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?"),

    ROMANNUMBER("[XVCIMDL]+"),

    WHILE("while"),
    DONE("done"),
    DO("do"),
    PRINT("print"),
    END(";"),


    ID("[a-z][a-z0-9]*"),

    INC("\\+\\+"),

    EQUAL("="),
    MORE(">"),
    LESS("<"),

    ADD("\\+"),
    SUB("-"),
    MUL("\\*"),
    DIV("/"),

    LPAR("\\("),
    RPAR("\\)"),
    SPACE("[ \t\r]+"),
    ENDL("\n");

    public final Pattern pattern;

    TokenType(String regexp) {
        pattern = Pattern.compile(regexp);
    }
}
