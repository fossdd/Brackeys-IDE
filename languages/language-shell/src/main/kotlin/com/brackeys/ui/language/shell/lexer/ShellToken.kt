package com.brackeys.ui.language.shell.lexer

enum class ShellToken {
    INTEGER_LITERAL,
    DOUBLE_LITERAL,

    BREAK,
    CASE,
    CONTINUE,
    ECHO,
    ESAC,
    EVAL,
    ELIF,
    ELSE,
    EXIT,
    EXEC,
    EXPORT,
    DONE,
    DO,
    FI,
    FOR,
    IN,
    FUNCTION,
    IF,
    SET,
    SELECT,
    SHIFT,
    TRAP,
    THEN,
    ULIMIT,
    UMASK,
    UNSET,
    UNTIL,
    WAIT,
    WHILE,
    LET,
    LOCAL,
    READ,
    READONLY,
    RETURN,
    TEST,

    TRUE,
    FALSE,

    MULTEQ,
    DIVEQ,
    MODEQ,
    PLUSEQ,
    MINUSEQ,
    SHIFT_RIGHT_EQ,
    SHIFT_LEFT_EQ,
    BIT_AND_EQ,
    BIT_OR_EQ,
    BIT_XOR_EQ,
    NOTEQ,
    EQEQ,
    REGEXP,
    GTEQ,
    LTEQ,

    PLUS_PLUS,
    MINUS_MINUS,
    EXPONENT,

    BANG,
    TILDE,
    PLUS,
    MINUS,
    MULT,
    DIV,
    MOD,

    SHIFT_LEFT,
    SHIFT_RIGHT,
    LT,
    GT,

    AND_AND,
    OR_OR,
    AND,
    XOR,
    OR,
    DOLLAR,
    EQ,
    BACKTICK,
    QUEST,
    COLON,

    LPAREN,
    RPAREN,
    LBRACE,
    RBRACE,
    LBRACK,
    RBRACK,
    SEMICOLON,
    COMMA,
    DOT,

    EVAL_CONTENT,

    SHEBANG,
    COMMENT,

    DOUBLE_QUOTED_STRING,
    SINGLE_QUOTED_STRING,

    IDENTIFIER,
    WHITESPACE,
    BAD_CHARACTER,
    EOF
}