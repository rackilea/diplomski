class FooException extends Exception { 
    private static final long serialVersionUID = 2816777468035627105L;
    private final String filename; 
    private final Throwable cause; 

    public FooException(String filename) { 
        this(filename, null); 
    }

    public FooException(String filename, Throwable cause) { 
        this.filename = filename; 
        this.cause = cause; 
    }

    @Override
    public String getMessage() { 
        return "Error reading file"; 
    }

    @Override
    public Throwable getCause() {
        return cause; 
    }

    public String getFilename() { 
        return filename; 
    }
}

public class Soj25375647 {    
    public static void main(String[] args) {
         try {
             throwsAnException();
             // Do other things that might throw my exception
         } catch (FooException e) { 
             System.err.printf("File: %s, error: %s, caused by %s%n", e.getFilename(), e, e.getCause());
         }
    }

    public static void throwsAnException() throws FooException { 
        try { 
            int x = 2 / 0;
        } catch (ArithmeticException e) { 
            throw new FooException("bob.file", e);   
        }
    }
}