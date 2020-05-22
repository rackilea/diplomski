public class InClassModule12 {
    public static void main(String[] args)
    {
        String[] countries = {
                "United States", "Brazil", "China", "Italy", "United Kingdom", "Spain",
                "Japan", "Germany", "France", "Turkey", "South Africa", "Argentina"};
        int[] populations = {
                319111000, 203462000, 1367960000, 60783711, 64105654, 46507760, 
                127090000, 80767000, 66050000, 76667864, 54002000, 42669500};

        Scanner input = new Scanner(System.in);
        try {
            PopulationLookup lookup = new PopulationLookup(countries, populations); 

            lookup.printAll();
            while(true) {
                System.out.println("Would you like to look up a country?");
                String response = input.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    System.out.println("Good bye");
                    break;
                }

                System.out.println("What country would you like to look up?");
                String country = input.nextLine();
                int population = lookup.populationForCountry(country);
                System.out.format("The population of %s is %d%n", country, population);
            }
        } finally {
            input.close();
        } 
    }
}