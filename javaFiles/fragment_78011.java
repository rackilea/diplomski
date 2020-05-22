public class Test {
    public static void main(String[] args) {

        System.out.println("Main Started");
        Child c = new Child();          //Instantiating Child Class
        System.out.println("Main Ended");
    }

}

class Father{

    Father(){                           //Father Class Default Constructor
        System.out.println("I am in Father in address " + System.identityHashCode(this));
    }

    void show(){
        System.out.println("Hello World");
    }
}

class Child extends Father{

    Child(){                            //Child Class Default Constructor
        System.out.println("I am in Child in address " + System.identityHashCode(this));
    }
}