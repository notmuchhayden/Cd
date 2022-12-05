package org.example.tour;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
public class ExtractInterfaceListener extends JavaBaseListener {
    JavaParser parser;
    public ExtractInterfaceListener(JavaParser parser) {
        this.parser = parser;
    }

    /** Listen to matches of classDeclaration */
    @Override
    public void enterNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
        System.out.println("interface I"+ctx.Identifier()+" {");
    }

    @Override
    public void exitNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
        System.out.println("}");
    }

    /** Listen to matches of methodDeclaration */
    /*
    // 교재에서 제시된 원래 문법
    methodDeclaration
        : type Identifier formalParameters ('[' ']')* methodDeclarationRest
        | 'void' Identifier formalParameters methodDeclarationRest
        ;
    */
    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx ) {
        // 교재에서 제시된 문법은 간단한 문법이지만,
        // 현재 추가된 Java.g4 는 더 복잡해진 문법이라 아래 코드로 한번에
        // 처리하는 것은 힘들고 여러 enter/exit 함수들을 재정의하여 돌아다니면서
        // 해결 해야 한다. 빨리 책을 끝내는 것이 목표 이므로 일단 넘어가자.

        // TODO : 현재 Java.g4 문법에서 동작하게 만들기
        // need parser to get tokens
        /*TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if ( ctx.type() != null ) {
            type = tokens.getText(ctx.type()); // 리턴 타입을 얻는다.
        }
        String args = tokens.getText(ctx.formalParameters()); // 파라메터를 얻는다.
        System.out.println("\t"+type+" "+ctx.Identifier()+args+";"); // type Identifier args; 형태로 출력한다.*/
    }
}
