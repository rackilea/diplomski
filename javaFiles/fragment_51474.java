int n = in.nextInt();
    String ar[] = new String [n]; //Array to store the names in.

    in.nextLine(); // < --- an extra next Line

    for (int i = 0; i<ar.length; i++)
    {
        System.out.println("Please enter the name: ");
        ar[i]= in.nextLine();

    }