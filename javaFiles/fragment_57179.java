package beanshell;

import java.util.Scanner;
import java.util.function.Supplier;

import bsh.EvalError;
import bsh.Interpreter;

public class InvokeStringArgument{
    public static Supplier<String> invokeMe(String returnStr){
        return new Supplier<String>(){
            public String get(){
                System.out.println("Success: Received string '"+returnStr+"'");
                return returnStr;
            }
        };
    }

    public static void main(String[] args) throws EvalError {
        //invokeMe("MyValue").get();

        System.out.println("Please enter string to evaluate:");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        Interpreter i = new Interpreter();

        Object evalSource = i.eval("public class EvalUserInput extends beanshell.InvokeStringArgument{"
                + "public void evaluserInput(){"
                + userInput+""
                + "}"
                + "}");
        try{
            Class<?> noparams[] = {};
            Class<?> cls = (Class) evalSource;
            Object obj = cls.newInstance();
            cls.getDeclaredMethod("evaluserInput", noparams).invoke(obj, null);
        } catch(Exception e){

        }
    }
}