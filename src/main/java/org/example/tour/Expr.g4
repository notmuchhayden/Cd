grammar Expr;

/** The start rule; begin parsing here. */
prog: stat+ ;


stat: expr NEWLINE
    | ID '=' expr NEWLINE
    | NEWLINE
    ;

// 좌 재귀를 허용한다.
expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | INT
    | ID
    | '(' expr ')'
    ;


ID : [a-zA-Z]+ ;        // match identifiers
INT : [0-9]+ ;          // match integers
NEWLINE:'\r'? '\n' ;    // return newlines to parser (is end-statement signal)
WS : [ \t]+ -> skip ;   // toss out whitespace