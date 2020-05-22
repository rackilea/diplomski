class X {
    private final String name = "Oscar";

    public int nameCount(){
        return this.name.length(); //<-- Will return 5 ALWAYS ( actually the compiler might inline it 
    }
 }