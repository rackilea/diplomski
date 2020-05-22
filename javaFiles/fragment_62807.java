public class TestMyString {
    public static void main(String[] args){
        String text = "Hello World!"
        MyString myString = new MyString(text);

        String subString = myString.subString(3)
        System.out.println(subString);
        // Output:  "o World!"

        System.out.println(myString);
        // output "Hello, World!"
    }
}