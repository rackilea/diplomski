public static void readFile(String file) throws FileNotFoundException
{
    Scanner s1 = new Scanner(new File(file));
    String[][] container = new String[2][2];
    int intIndex = 0;
    int doubleIndex = 0;
    while(s1.hasNextLine())
    {
        String line = s1.nextLine();
        System.out.println(line);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String[] splitLine = line.split(" ");
        for (String text : splitLine) {
            if (text.matches("\\d*")) 
            {
                System.out.println(text + " is int");

                //checking the array for duplicates
                if (Arrays.stream(container[0]).anyMatch(text::equals)) {
                    continue;
                }


                if (container[0].length == intIndex) 
                {
                    container[0] = Arrays.copyOf(container[0], intIndex + 2); 
                    container[1] = Arrays.copyOf(container[1], doubleIndex + 2); 
                }
                container[0][intIndex] = (text); 
                intIndex++; //adjust the index
            } else if (text.matches("\\d*.\\d*")) 
            {
                System.out.println(text + " is double");

                //checking the array for duplicates
                if (Arrays.stream(container[1]).anyMatch(text::equals)) {
                    continue;
                }


                if (container[1].length == doubleIndex) 
                {
                    container[0] = Arrays.copyOf(container[0], intIndex + 2); 
                    container[1] = Arrays.copyOf(container[1], doubleIndex + 2); 
                }
                container[1][doubleIndex] = (text); 
                doubleIndex++; 
            } else 
            {
                System.out.println(text + " is not int nor double");
            }
        }
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    //compare numerically rather than alphabetically in sorting
    Arrays.sort(container[0], Comparator.nullsLast((e1, e2) -> 
            Integer.valueOf(e1).compareTo(Integer.valueOf(e2))));
    Arrays.sort(container[1], Comparator.nullsLast((e1, e2) -> 
            Double.valueOf(e1).compareTo(Double.valueOf(e2))));


    System.out.println(Arrays.toString(container[0]));
    System.out.println(Arrays.toString(container[1]));
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}