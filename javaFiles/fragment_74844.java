import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class SimpleTests2 {

    public static void main(String[] args) throws ParseException {

        sortingOrder();
    }

    //Method takes a String to Sort AlphabeticalLy
    public static boolean checkAlphabeticalOrder(Collection<String> product_names) {

        String previous = ""; // empty string

        for (final String current : product_names) {
            if (current.compareTo(previous) < 0)
                return false;
            previous = current;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static void sortingOrder() {

//        Log.log(driver).info("About to Alphebetically Sort");
        List<MobileElement> products_MobileElements;
        products_MobileElements = Arrays.asList(
                new MobileElement("Mike Durov"), new MobileElement("Jack Daniels"), new MobileElement("John Fera"));
        // Here is the main change to your code!
        Collection<String> product_names = new TreeSet<>();

        for (int i = 0; i < products_MobileElements.size(); i++) {

            String s = products_MobileElements.get(i).getAttribute("checked");
            String[] tokens = s.split(" ");
            String firstName = "";
            String lastName = "";
            if (tokens.length > 0) {
                firstName = tokens[0];
                lastName = tokens[tokens.length - 1];
                product_names.add(s);
                product_names.add(firstName);
                product_names.add(lastName);
            }
        }
        boolean result = checkAlphabeticalOrder(product_names);

//        Assert.assertEquals(checkAlphabeticalOrder(product_names), true);
//        Log.log(driver).info("Tickest Passes names are in alphabetical order.");
        System.out.println(result);
        System.out.println(product_names);
    }


    private static class MobileElement {

        private String name;

        public MobileElement(String name) {
            this.name = name;
        }

        public String getAttribute(String checked) {
            return name;
        }
    }
}