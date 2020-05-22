SomeClass selfRef;

public void log(){
    selfRef.callme();
    System.out.println("Hello from logger ~~~~~~~~~~~~~~~~~~~");
}

public void callme(){
    System.out.println("I'm called");
}