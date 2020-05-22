public class UserInput {
    private String[] cityInArr;

    public void city() {
        System.out.println("How many favourite city you have in your list?");
        Scanner inScanner = new Scanner(System.in);
        int numOfCity = inScanner.nextInt();
        cityInArr = new String[numOfCity];

        for (int i = 0; i < numOfCity; i++) {
            System.out.println("City " + (i + 1) + ": ");
            cityInArr[i] = inScanner.next();
        }
        System.out.println("YOU ARE DONE! NOW PRINT THEM OUT");
    }

    public void printCity() {
        System.out.println("\nThese are your favorite cities: ");
        for (int j = 0; j < cityInArr.length; j++) {//has an error
            System.out.printf("%s ", cityInArr[j]);//has an error
        }
    }
}