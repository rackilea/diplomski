class MySeviceException extends Exception{
    public MySeviceException() {}  
    public MySeviceException(String msg) { super(msg); }  
    public MySeviceException(Throwable cause) { super(cause); }  
    public MySeviceException(String msg, Throwable cause) { super(msg, cause); } 
}

interface A
{
    void x() throws MySeviceExceptionException;
    void y() throws MySeviceExceptionException;
}