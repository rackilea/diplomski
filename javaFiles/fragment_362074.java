public class A<SUB extends A<SUB>> {
    private int num;

    public A(int num){
        this.num = num;
    }

    public SUB square(){
        int temp = num * num;

        return newInstance(temp);
    }

    protected abstract SUB newInstance(int temp);
}

public class B extends A<B> {
    public B(int num){
        super(num);
    }

    protected B newInstance(int temp)  {
        retunr new B(temp);
   } 
}

public static void main(String...args){
    B first = new B(4);

    B second = first.square();
}