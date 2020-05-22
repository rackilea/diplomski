public class Test {

    public static void main(String[] args) {

        String name = "John King IV. Cena";

        int start = name.indexOf(' ');
        int end = name.lastIndexOf(' ');

        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (start >= 0) {
            firstName = name.substring(0, start);
            if (end > start)
                middleName = name.substring(start + 1, end);
            lastName = name.substring(end + 1, name.length());
        }    

        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(lastName);
    }
}