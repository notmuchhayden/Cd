grammar LabeledExpr;        // Rename to distinguish from original
import CommonLexerRules;    // includes all rules from CommonLexerRules.g4

/** The start rule; begin parsing here. */
prog: stat+ ;

// NEWLINE 은 상위 문법에만 적용하여 Statement Ending 을 표현한다.
stat: expr NEWLINE              # printExpr
    | ID '=' expr NEWLINE       # assign
    | NEWLINE                   # blank
    ;

expr: expr op=('*'|'/') expr    # MulDiv
    | expr op=('+'|'-') expr    # AddSub
    | INT                       # int
    | ID                        # id
    | '(' expr ')'              # parens
    ;

MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;