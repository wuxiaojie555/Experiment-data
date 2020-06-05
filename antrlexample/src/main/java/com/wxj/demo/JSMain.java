package com.wxj.demo;


import main.resources.*;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class JSMain {
    public static void main(String[] args) throws IOException {
        //CharStream input = CharStreams.fromString("var x =1; var y=x+2;");
        CharStream input = CharStreams.fromString("function foo()\n" +
                "{\n" +
                "    var o = Error();\n" +
                "    for(let i in o)\n" +
                "    {\n" +
                "        o[i];\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "var bb = foo();");
//        CharStream input = CharStreams.fromString("var q;\n" +
//                "function g(){\n" +
//                "\tq = g.caller;\n" +
//                "\treturn 7;\n" +
//                "}\n" +
//                "\n" +
//                "\n" +
//                "var a = [1, 2, 3];\n" +
//                "a.length = 4;\n" +
//                "Object.defineProperty(Array.prototype, \"3\", {get : g});\n" +
//                "[4, 5, 6].concat(a);\n" +
//                "q(0x77777777, 0x77777777, 0);");
        //CharStream input = CharStreams.fromString("x>=y");
        //ANTLRInputStream input = new ANTLRInputStream(System.in);

        // 构造词法分析器
//        ECMAScriptLexer lexer=new ECMAScriptLexer(input);
//
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // 实例化解析器
//        ECMAScriptParser parser = new ECMAScriptParser(tokens);
        // 构造词法分析器
        JavaScriptLexer lexer = new JavaScriptLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 实例化解析器
        JavaScriptParser parser = new JavaScriptParser(tokens);
//
        ParseTree tree = parser.program();
        //HelloBaseVisitor visitor = new HelloBaseVisitor();

        //System.out.println(visitor.visit(tree));

        System.out.println(tree.getText());

        System.out.println(tree.toStringTree(parser));

       //将提取出来的树转化成了自己定义的树
       TreeNode root =  Treeget.gettree(tree,parser);
        System.out.println(root.gettext());
        System.out.println(root.getpath(root).get(1));

//       TreeNode child1 = root.getChlidren().get(0);
//        System.out.println(root.getStatement());
//        for(int i =0 ;i<child1.getChlidren().size();i++){
//            System.out.println(child1.getChlidren().get(i).getStatement());
//        }


//        ParseTreeWalker walker = new ParseTreeWalker();
//
//        ECMAScriptBaseListener listener = new ECMAScriptBaseListener();
//
//        walker.walk(listener,tree);




    }
}
