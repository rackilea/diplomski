@Component
public class MessageDisplayer {

    public void displayMessage(String message) {
        System.out.println(message);
    }

}

@Component
public class MessageGetter {

    public String getMessage() {
        return "Real Hello";
    }

}