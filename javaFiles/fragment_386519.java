for (int a = 1; a > 0; a++) {
    System.out.println("\nenter name to find number:\n");
    String name2 = myScan.nextLine();
    boolean isNameFound = false;
    for (int b = 0; b < 200; b++) {
        if (name2.equals(name[b])) {
            System.out.println("number is " + number[b]);
            isNameFound = true;
            break;
        }
    }
    if (!isNameFound)
        System.out.println("----THE NAME IS NOT IN THE LIST----\n");
}