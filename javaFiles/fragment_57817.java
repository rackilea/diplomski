package stackoverflow;

import java.io.ObjectInputStream.GetField;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;

public class StackTrace {

    @Retention(RetentionPolicy.RUNTIME)
    public static @interface TopLevelCallElement {

    }


    private void connect(){
        throw new RuntimeException("some database error");
    }

    private void getDatabaseConnection(){
        connect();
    }

    @TopLevelCallElement
    private void getName(){
        getDatabaseConnection();
    }

    @TopLevelCallElement
    public void getCredentials(){
        getName();
    }


    public static StackTraceElement getTopLevelFunction(Throwable exception){

        // iterate stack trace in reverse order
        StackTraceElement [] stackTrace = exception.getStackTrace();
        for (int i=stackTrace.length-1;i>=0;i--){
            StackTraceElement traceElement=stackTrace[i];
            try {
                Class<?> callerClass = Class.forName(traceElement.getClassName());

                for (Method method:callerClass.getDeclaredMethods()){
                    if (method.getName().equals(traceElement.getMethodName())){
                        // we got a method in a class that might be (unless it's an overloaded method)
                        // a method that really threw exception.
                        if (method.getAnnotation(TopLevelCallElement.class)!=null){
                            return traceElement;
                        }

                    }
                }

            } catch (ClassNotFoundException e) {
                // should not happen, we know we're callling Class.forName with existing classes

            }

        }

        // in case no apropriate stack trace element was found, just return the most deepest one
        return stackTrace[stackTrace.length-1];
    }

    public static void logExceptionElement(Throwable exception){
        StackTraceElement element = getTopLevelFunction(exception);
        System.err.println(String.format("Exception in class %s, method %s, line %d",
                element.getClass().getName(),
                element.getMethodName(),
                element.getLineNumber(),
                exception.getMessage()
                ));

    }

    public static void main(String[] args) {
        StackTrace test = new StackTrace();


        try{
            test.getCredentials();
        }
        catch (RuntimeException err){
            // should log "getCredentials()" as top level function exception point
            logExceptionElement(err);
        }


        try{
            test.getName();
        }
        catch (RuntimeException err){
            // should log "getName()" as top level function exception point
            logExceptionElement(err);
        }

    }

}