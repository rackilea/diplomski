public class Hello
{
    // value / method
    public static String staticValue;
    public String nonStaticValue;

    public void main(String[] args){

      Hello hello = new Hello();
      Hello.staticValue = "abc";
      hello.nonStaticValue = "xyz";

      Hello hello2 = new Hello(); // here staticValue = "abc"
      Hello.staticValue; // will have value of "abc"
      hello2.nonStaticValue; // will have value of null
    }
}