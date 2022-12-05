package org.example.starter;

// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class ArrayInitRun {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length > 0 )
            inputFile = args[0];

        InputStream is = System.in;
        if ( inputFile != null )
            is = new FileInputStream(inputFile);

        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(is);
        //ANTLRInputStream input = new ANTLRInputStream(System.in);
        // create a lexer that feeds off of input CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init(); // begin parsing at init rule
        //System.out.println(tree.toStringTree(parser));

        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new ShortToUnicodeString(), tree);
        System.out.println(); // print a \n after translation
    }
}
