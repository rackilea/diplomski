package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MyJavaClass {
    public static void main(String arg[]) throws ScriptException,
            FileNotFoundException {

        ScriptEngine jruby = new ScriptEngineManager().getEngineByName("jruby");
        jruby.eval(new BufferedReader(new FileReader("example.rb")));
        Object example = jruby.eval("Example::Myclass.new");
        jruby.put("a", example);
        System.out.println(jruby.eval("$a.t_st"));

    }
}