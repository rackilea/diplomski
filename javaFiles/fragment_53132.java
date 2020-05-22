System.out.println("NOW YOU CAN SEE ME");

PrintStream originalStream = System.out;

PrintStream dummyStream = new PrintStream(new OutputStream(){
    public void write(int b) {
        // NO-OP
    }
});

System.setOut(dummyStream);
System.out.println("NOW YOU CAN NOT");

System.setOut(originalStream);
System.out.println("NOW YOU CAN SEE ME AGAIN");