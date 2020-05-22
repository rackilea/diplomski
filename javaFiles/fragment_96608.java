import java.util.*;

class CitySortDemo {

    public static void main(String[] args) {
        final String specifier = "!";
        String str;
        ArrayList<String> cities = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("enter as many cities as you can!");
        str = input.nextLine();
        while (! str.equals(specifier)) {
            cities.add(str);
            str = input.nextLine();
        }
        Collections.sort(cities);
        cities.forEach(System.out::println);
    }