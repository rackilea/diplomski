while (true) {
    System.out.println("Enter the cell you want to check");
    String stringCell = nameScanner.nextLine();

    if (stringCell != null && stringCell.trim().length() == 2) {
        if (Character.isLetter(stringCell.charAt(0)) && Character.isDigit(stringCell.charAt(1)))
                break;
    }

    System.err.println("Wrong input");
}