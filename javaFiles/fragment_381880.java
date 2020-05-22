public static void fillArrayList(ArrayList<Integer> myList) {
    /* Let the code be same as the one in @AmitD's post */

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elemetns for List: Enter -1 to end ");

    while (scanner.hasNext()) {
        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i == -1)
                break;

            myList.add(i);
        } else {
            System.out.println("Invalid value Please enter integer");
            scanner.next();
        }
    }

}