public class OnePossibleSolution { // no "implements"

    private String interface1Method() {
        return "whatever";
    }

    public Interface1 asInterface1() {
        return new Interface1() {
            @Override
            String method() {
                return interface1Method();
            }
        }
    }

    // ditto for Interface2...