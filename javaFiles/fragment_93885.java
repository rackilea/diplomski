Scanner input = new Scanner(System.in);

    while (input.hasNextLine()) {

        String str = input.nextLine();  // Apple, Fruit, 10, 5.67

        String arr[] = str.split (", ");

        for (String s : arr) {
            System.out.println(s);
        }
    }