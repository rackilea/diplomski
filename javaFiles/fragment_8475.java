package cruft;

/**
 * Created by Michael
 * Creation date 3/24/2018.
 * @link https://stackoverflow.com/questions/49465133/junit-no-runnable-methods?noredirect=1#49465133
 */
public class ClassToTest {

    private String message;
    public ClassToTest(String message){
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }
}