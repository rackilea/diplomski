import java.io.ByteArrayInputStream;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public static void main(String[] args) throws ParseException {
        String java = new String("public class ThisIsANonWellFormattedJavaClass {public static void main(String[] args){}}");
        CompilationUnit cu = JavaParser.parse(new ByteArrayInputStream(java.getBytes()));
        System.out.println(cu.toString());
    }