import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        String address = "https://www.cia.gov/library/publications/the-world-factbook/rankorder/rawdata_2151.txt";
        URL pageLocation = new URL(address);
        Scanner in1 = new Scanner(pageLocation.openStream());
        Scanner in = new Scanner(System.in);
        String line;
        System.out
                .print("Please enter the name of the country you would like to see the mobile users for: ");
        String country = in.next();

        while (in1.hasNextLine()) {
            line = in1.nextLine();
            String[] data = line.split("\t");

            if (data[1].contains(country) == true) {
                System.out.println("Country name: " + data[1]);
                System.out.println("Mobile phone subscribers: " + data[2]);
                return; //<--- will exit after printing ^
            }
        }
        System.out.println("No country found with that name!");
    }
}