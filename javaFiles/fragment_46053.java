package test1;

public class First {
    public int someInt;

    public static void main(String[] args) {
        First x = new First();
    }

    public First(){
        someInt = 9;
        Second y = new Second();
    }

    class Second {
        public Second(){
            someInt = 10;
            System.out.println(someInt);
        }
    }
}