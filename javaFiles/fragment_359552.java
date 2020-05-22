import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        Optional<String> startingOptional = Optional.ofNullable(null);
        List<String> finishingValue =
                startingOptional
                    .map(value -> Arrays.asList(value.split(",")))
                    .orElseGet(() -> {
                        System.out.println("value not found"); 
                        return new ArrayList<String>();
                    });
        System.out.println("finishingValue: " + finishingValue);
    }
}