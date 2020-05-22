class A { 
    protected int a = 15; 
}

class B extends A { 
    private int a = 10;

    public void printA() {
       System.out.println(super.a); // prints 15
       System.out.println(this.a); // prints 10
    }
}