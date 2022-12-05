grammar Data;
file : group+ ;

group: INT sequence[$INT.int] ; // 자식 문법으로 앞서 나온 INT 값을 넘김.

sequence[int n]                 // 부모 문법에서 넘길 파라메터를 int n 으로 선언
locals [int i = 1;]             // 이 문법 안에서 사용할 지역 변수 선언
    : ( {$i<=$n}? INT {$i++;} )* // match n integers
    ;

INT : [0-9]+ ; // match integers
WS : [ \t\n\r]+ -> skip ; // toss out all whitespace