class dog implements animal{public void eat(){System.out.println("dog is eating");}}

class cat implements animal{public void eat(){System.out.println("cat is eating");}}

class test{
public static void main(String arg[]){
    String input = "dog";
    animal testAnimal = null;

    try{
        testAnimal = Class.forName(input).newInstance();
    }
    catch(Exception e){}
}}