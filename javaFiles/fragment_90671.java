public static void animal()
    {
        int[] array = new int[5];
        int j = 0;
        String[] names = {"Komodo Dragon" , "Manatee" , "Kakapo" , "Florida Panther" , "White Rhino"};
        System.out.println("Please enter the number of wild Komodo Dragons, Manatee, Kakapo, Florida Panthers and White Rhinos.");
        Scanner scan = new Scanner(System.in);
        int minVal = Integer.MAX_VALUE;
        int minValIndex = -1;
        for (int i=0; i<=4; i++)
        {
                array[j] = scan.nextInt();
                if(array[j] < minVal) {
                    minVal = array[j];
                    minValIndex = j;
                }
                int max = array[j];
                j++;
                if(j==5)
                {
                    System.out.println(array[0] + ", " + names[0]);
                    System.out.println(array[1] + ", " + names[1]);
                    System.out.println(array[2] + ", " + names[2]);
                    System.out.println(array[3] + ", " + names[3]);
                    System.out.println(array[4] + ", " + names[4]);
                }

        }
        System.out.println("The smallest entered number:" + minVal);
        System.out.println("The species:" + names[minValIndex]);
    }