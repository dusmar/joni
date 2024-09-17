package org.joni.test;

import org.jcodings.Encoding;
import org.jcodings.specific.ASCIIEncoding;
import org.joni.Option;
import org.joni.Syntax;

public class TestD extends Test {
    @Override
    public int option() {
        return Option.DEFAULT;
    }

    @Override
    public Encoding encoding() {
        return ASCIIEncoding.INSTANCE;
    }

    @Override
    public String testEncoding() {
        return "iso-8859-2";
    }

    @Override
    public Syntax syntax() {
        return Syntax.TEST;
    }


    @Override
    public void test() throws Exception {
        x2s("((?<=^.{1})|(?<=^.{2})|(?<=^.{3})|(?<=^.{4}))A", "123A", 3, 4);
        x2s("(?<=^.{0,4})A", "123A", 3, 4);

        String pattern = "^.*(?:Relocation Dictionary|Ordinary Symbol and Literal Cross Reference|Macro and Copy Code Source Summary|Dsect Cross Reference|Using Map|General Purpose Register Cross Reference|Diagnostic Cross Reference and Assembler Summary).*Page....\\d(?<=^.{120}).*";
        // Test input strings
        String testMatch = "Relocation Dictionary Page 123 ... some text with exactly 120 characters ... ";
        x2s("(?<=^.{0,4})A", "123A", 3, 4);
        ns(pattern, testMatch);



    }
}
