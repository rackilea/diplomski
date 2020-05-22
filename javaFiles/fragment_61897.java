import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddingCLI {

    private final AddingModel model ;

    private final Pattern intPattern = Pattern.compile("-?[0-9]+");

    public AddingCLI(AddingModel model) {
        this.model = model ;
    }

    public void processCommandLine() {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String input = in.next().trim().toLowerCase();
                if (intPattern.matcher(input).matches()) {
                    int value = Integer.parseInt(input);
                    model.addValue(value);
                } else if ("show".equals(input)) {
                    outputValues();
                } else if ("clear".equals(input)) {
                    model.clear();
                    System.out.println("Values cleared");
                } else if ("total".equals(input)) {
                    System.out.println("Total = "+model.getTotal());
                }
            }
        }
    }

    private void outputValues() {
        List<Integer> values = model.getValues();
        if (values.isEmpty()) {
            System.out.println("No values");
        } else {
            values.forEach(System.out::println);
        }
    }
}