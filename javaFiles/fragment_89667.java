import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestShop {

    public static final String MALBORO_LIGHTS = "Malboro Lights";
    public static final String MALBORO_LIGHTS_SOFT = "Marlboro Lights, Soft Pack";
    public static final String MALBORO_LIGHTS_FLIP = "Marlboro Lights, Flip Pack";

    public static final String MALBORO_RED = "Malboro Reds";
    public static final String MALBORO_RED_SOFT = "Marlboro Reds, Soft Pack";
    public static final String MALBORO_RED_FLIP = "Marlboro Reds, Flip Pack";

    public static final String DUNHILL = "Dunhill";
    public static final String DUNHILL_SOFT = "Dunhill, Soft Pack";
    public static final String DUNHILL_FLIP = "Dunhill, Flip Pack";

    public static final String PHILLIP = "Phillip";
    public static final String PHILLIP_SOFT = "Phillip, Soft Pack";
    public static final String PHILLIP_FLIP = "Phillip, Flip Pack";

    public static void main(String[] args) {
        new TestShop();
    }

    public TestShop() {
        Scanner keyboard = new Scanner(System.in);

        /**************************************************************************/
        /* This part is dynamic, change this when you want new items, prices or   */
        /* groups                                                                 */
        /**************************************************************************/

        // A list of items that have been ordered
        Map<String, Integer> orders = new HashMap<>(25);

        // A list of items keyed to prices
        Map<String, Double> prices = new HashMap<>(25);
        prices.put(MALBORO_LIGHTS_SOFT, 70d);
        prices.put(MALBORO_LIGHTS_FLIP, 80d);
        prices.put(MALBORO_RED_SOFT, 70d);
        prices.put(MALBORO_RED_FLIP, 80d);
        prices.put(DUNHILL_SOFT, 60d);
        prices.put(DUNHILL_FLIP, 70d);
        prices.put(PHILLIP_SOFT, 70d);
        prices.put(PHILLIP_FLIP, 80d);

        // Mapping items to groups...
        Map<String, List<String>> groups = new HashMap<>(25);
        groups.put(MALBORO_LIGHTS, new ArrayList<>(Arrays.asList(new String[]{MALBORO_LIGHTS_SOFT, MALBORO_LIGHTS_FLIP})));
        groups.put(MALBORO_RED, new ArrayList<>(Arrays.asList(new String[]{MALBORO_RED_SOFT, MALBORO_RED_FLIP})));
        groups.put(DUNHILL, new ArrayList<>(Arrays.asList(new String[]{DUNHILL_SOFT, DUNHILL_FLIP})));
        groups.put(PHILLIP, new ArrayList<>(Arrays.asList(new String[]{PHILLIP_SOFT, PHILLIP_FLIP})));

        /**************************************************************************/

        /**************************************************************************/
        /* The rest of this is pretty static and is driven by the data from above */
        /* This means, you don't need change anything below here, when the stuff  */
        /* changes                                                                */
        /**************************************************************************/

        boolean done = false;
        do {
            System.out.println("Welcome to my shop");
            List<String> keys = new ArrayList<>(groups.keySet());
            for (int index = 0; index < keys.size(); index++) {
                System.out.println("[" + (index + 1) + "] " + keys.get(index));
            }
            System.out.println("[0] Exit");
            String input = keyboard.nextLine();
            try {
                int selectedIndex = Integer.parseInt(input);
                if (selectedIndex == 0) {
                    done = true;
                } else if (selectedIndex > 0 && selectedIndex <= keys.size()) {
                    String key = keys.get(selectedIndex - 1);

                    List<String> items = groups.get(key);
                    boolean subDone = false;
                    do {
                        System.out.println("Items for " + key + "....");
                        for (int index = 0; index < items.size(); index++) {
                            System.out.println("  [" + (index + 1) + "] " + items.get(index));
                        }
                        System.out.println("  [0] Return");
                        input = keyboard.nextLine();
                        try {
                            int index = Integer.parseInt(input);
                            if (index > 0 && index <= items.size()) {
                                index--; // The items in the list are 0 indexed
                                String item = items.get(index);
                                Integer quanity = orders.get(item);
                                if (quanity == null) {
                                    quanity = 1;
                                } else {
                                    quanity++;
                                }
                                orders.put(item, quanity);
                            } else if (index == 0) {
                                subDone = true;
                            } else {
                                System.out.println("Invalid selection, please try again");
                            }
                        } catch (NumberFormatException exp) {
                            System.out.println("!! " + input + " is not a valid selection");
                        }
                    } while (!subDone);
                } else {
                    System.out.println("Invalid selection, please try again");
                }
            } catch (NumberFormatException exp) {
                System.out.println("!! " + input + " is not a valid selection");
            }

        } while (!done);

        double total = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {

            int quanity = entry.getValue();
            double price = prices.get(entry.getKey());

            total += quanity * price;

            System.out.println(String.format(
                    "%-20s x %4d @ %7s = %10s",
                    entry.getKey(),
                    quanity,
                    NumberFormat.getCurrencyInstance().format(price),
                    NumberFormat.getCurrencyInstance().format(quanity * price)));

        }

        System.out.printf("%-20s   %4s   %7s   ==========%n", "", "", "");
        System.out.printf("%-20s   %4s   %7s   %10s%n", "", "", "", NumberFormat.getCurrencyInstance().format(total));
    }

}