public static void main(String[] args) {

        String[] numbers = { "1", "2", "3", "4", "5", "6", "7" };
        String[] brands = { "aa", "bb", "cc", "dd", "ee", "ff", "gg" };
        String[] types = { "hh", "ii", "jj", "kk", "ll", "mm", "nn" };

        Soda[] list = new Soda[numbers.length];
        list = Soda.listOfSodaCans(numbers, brands, types);

        // way 2, accessing by instance
        // Soda soda = new Soda();
        // list = soda.listOfSodaCans(numbers, brands, types);
    }