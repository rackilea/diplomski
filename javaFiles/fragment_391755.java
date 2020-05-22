public class MyClass(){
    MyClass(){
        callerName = Thread.currentThread().getStackTrace()[2].getFileName();
        ... // anything here
    }
}