public class MyTest {
    public static void main(String[] args) {

        //First of all, we need an instance of an Election-type object, so
        //that we can call its methods and get votes from users.
        Election e = new Election();
        //Now we can easily call the method getVotes(), as defined in Election class.
        //What happens here, is that the program will 'jump' to the getVotes() method
        //and it will execute every line of code in that method. Then it will
        //'return' to where it 'left off' in the main() method. Since getVotes()
        //is of type 'void', it will not return anything. It will just 'jump' back.
        e.getVotes();

        //Now, you can use testResult() method, to see the values of the variables.
        e.testResult();
    }
}