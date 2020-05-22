class Cycle{
    protected int w;
    public void move(){
        System.out.println("Cycle moving");
    }
    public int wheels(){
        return w;
    }
}

class Unicycle extends Cycle{
    public Unicycle() {
        w = 1;
    }
     public void go(){
        System.out.println("Unicycle go");
    }
}