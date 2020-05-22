class Parent{
    private int x=10;

    public int getX() {
        return x;
    }

    void show(){
        System.out.println(this.getX());
    }
}

class Child extends Parent{
    int x=20;

    @Override
    public int getX() {
        return x;
    }

    public static void main(String[] args){
        Child c=new Child();
        c.show();
    }
}