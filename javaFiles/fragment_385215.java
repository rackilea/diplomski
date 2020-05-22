package com.pasuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

public class ScriptTest {

    public static class Logger {
        public void log(String message) {
            System.out.println(message);
        }
    }

    public static class Dice {
        private Random random = new Random();
        public int D6() {
            return random.nextInt(6) + 1;
        }
    }

    public static void main(String[] args) {
        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine(new String[]{"-strict", "--no-java", "--no-syntax-extensions"});
        //note final, does not work.
        final Dice dice = new Dice();
        final Logger logger = new Logger();
        engine.put("dice", dice);
        engine.put("log", logger);
        engine.put("hello", "world");
        try {

            engine.eval("log.log(hello);");
            engine.eval("log.log(Object.keys(this));");

            engine.eval("log.log(dice.D6());"
                    + "log.log(dice.D6());"
                    + "log.log(dice.D6());");

            engine.eval("log.log(Object.keys(this));");
            engine.eval("Coffee"); //boom as should
            engine.eval("Java"); //erm? shoud boom?
            engine.eval("log = 1;"); //override final, boom, nope
            engine.eval("log.log(hello);"); //boom
        } catch (final ScriptException ex) {
            ex.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        do {
            try {
                input = br.readLine();
                engine.eval(input);
            } catch (final ScriptException | IOException se) {
                se.printStackTrace();
            }
        } while (!input.trim().equals("quit"));

        try {
            engine.eval("var add = function(first, second){return first + second;};");
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction("add", 1, 2);
            System.out.println(result);

        } catch (final NoSuchMethodException | ScriptException se) {
            se.printStackTrace();
        }
        Object l = engine.get("log");
        System.out.println(l == logger);
    }
}