class C{
    private String field;
    private int anotherField;
    private D d;

    public C(){}

    public C(C other){
        this.field = other.field;
        this.anotherField = other.anotherField;
        this.d = new D(other.d); //watch out when copying mutable objects; they should provide copy constructors, as well. Otherwise, a deep copy may not be possible
    }

    //getters and setters
}

class D{//mutable class

    //fields
    public D(D other){
        //this is a copy constructor, like the one for C class
    }
}