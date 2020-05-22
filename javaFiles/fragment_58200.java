public class Test {
     public void protectedInternal() {
         // If this method is not called from an inherited class.
         if (getClass() == Test.class) {
             StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
             StackTraceElement e = stackTrace[2]; // Corresponds to the caller stack frame.
             // Check the caller is from the allowed package.
             if (!e.getClassName().startsWith("my.package.")) {
                 throw new SecurityException("Sorry, this method is kind of protected internal :)");
             }
         }
     }
}