import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Loader;
import javassist.NotFoundException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioPump {

    private static String expression;

    public static void main(String[] args) throws Exception {
        System.out.print("Enter expression(use t as variable):");
        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
        expression = consoleReader.readLine();
        generateMethod(expression);
        AudioFormat format = new AudioFormat(8000f, 8, 1, false, false);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        SourceDataLine soundLine = (SourceDataLine) AudioSystem.getLine(info);
        soundLine.open(format, 32000);
        soundLine.start();

        byte[] buffer = new byte[8];
        int t = 0;

        while (true) {
            for (int n = 0; n < buffer.length; n++) {
                buffer[n] = (byte) invokeF(t++);
            }
            soundLine.write(buffer, 0, buffer.length);
        }
    }

    private static byte invokeF(int i) {
        java.lang.reflect.Method method = null;
        try {
            ClassPool pool = ClassPool.getDefault();
            Loader cl = new Loader(pool);
            Class expressionEvaluatorClass = cl.loadClass("ExpressionEvaluator");
            method = expressionEvaluatorClass.getMethod("f", Integer.TYPE);
        } catch (SecurityException e) {
            e.printStackTrace();System.exit(-1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();System.exit(-1);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();System.exit(-1);
        }
        try {
            return (Byte) method.invoke(null, i);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();System.exit(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();System.exit(-1);
        } catch (InvocationTargetException e) {
            e.printStackTrace();System.exit(-1);
        }
        return 0;
    }

    private static void generateMethod(String expression2) {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass pt = pool.get("ExpressionEvaluator");
            String methodString = "public static byte f(int t) { return (byte)(" + expression2 + ");}";
            System.out.println(methodString);
            CtMethod m = CtNewMethod.make(methodString, pt);
            pt.addMethod(m);
            pt.writeFile();
        } catch (NotFoundException e) {
            e.printStackTrace();System.exit(-1);
        } catch (CannotCompileException e) {
            e.printStackTrace();System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();System.exit(-1);
        }
    }

    // return (t*(t>>5|t>>8))>>(t>>16);
    // return t*(((t>>12)|(t>>8))&(63&(t>>4)));
}