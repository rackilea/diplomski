public class HelloWorld{

    public static void main(String[] args){

    Hello he = new Hello();
    he.sayHelloToMe(); // if you replace this line by he.sayHelloToYou(); then this method will execute at the first place
    he.sayHelloToYou();
    }
}

class Hello{

    public void sayHelloToMe()
    {
        System.out.println("Hello to me!");
    }

    public void sayHelloToYou()
    {
        System.out.println("Hello to you!");
    }
 }