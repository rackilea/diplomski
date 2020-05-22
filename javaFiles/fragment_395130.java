import java.util.Scanner;

public class TravelAgent {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);

        String[] countries = {
            "Greece", "Spain", "France"
        };

        int[] country_prices = {
            300, 400, 200
        };

        String[][] hotels = new String[3][];

        hotels[0] = new String[]{
            "Lindos Blu", "Saint Andrea", "The Excelsior", "Elite Suites", "Avithos", "New Hotel", "The Met Hotel",
            "TesoroBlu Hotel & Spa", "Mykonos Grand Hotel", "Achtis Hotel"
        };
        hotels[1] = new String[]{
            "Alma Barcelona", "Seaside Grand Hotel Residencia", "Hotel Primero Perimera", "Valbusenda Resort",
            "Hotel Maria Cristina", "Gran Hotel La Perla", "El Palace Hotel",
            "Tinas de Pechon", "Dream Hotel Gran Tacande", "Protur Palmeras Playa"
        };
        hotels[2] = new String[]{
            "Le Bristol Paris", "Hotel Plaza Athenee", "Hotel Fabric", "La Maison Favart", "Hotel Le Six",
            "Hotel Royal Riviera", "Hotel Crillon Le Brave", "Mandarin Oriental", "Le Mareuil", "Hotel d’Europe"
        };

        int[][] hotel_prices = new int[3][];
        hotel_prices[0] = new int[]{
            70, 90, 100, 140, 80, 75, 200, 110, 160, 230
        };
        hotel_prices[1] = new int[]{
            50, 70, 90, 100, 120, 140, 160, 180, 200, 230
        };
        hotel_prices[2] = new int[]{
            60, 60, 70, 75, 80, 90, 105, 120, 140, 200
        };

        while (true) {
            System.out.println("Please select your holiday destination");
            for (int i = 0; i < countries.length; ++i) {
                System.out.println((i + 1) + "." + countries[i]);
            }
            System.out.println("Enter destination from 1-" + countries.length);

            int country_choice = keyboard.nextInt();
            if (-99 == country_choice) {
                return;
            }
            System.out.println("Chosen country: " + countries[country_choice - 1]);
            System.out.println("Country price: " + country_prices[country_choice - 1] + ".00");


            System.out.println("Please select your hotel");
            for (int i = 0; i < hotels[country_choice - 1].length; ++i) {
                System.out.println((i + 1) + "." + hotels[country_choice - 1][i]);
            }
            System.out.println("Enter hotel from 1-" + hotels[country_choice - 1].length);

            int hotel_choice = keyboard.nextInt();
            if (-99 == hotel_choice) {
                return;
            }
            System.out.println("Chosen hotel: " + hotels[country_choice - 1][hotel_choice - 1]);
            System.out.println("Hotel price: " + hotel_prices[country_choice - 1][hotel_choice - 1] + ".00");
        }
    }
}