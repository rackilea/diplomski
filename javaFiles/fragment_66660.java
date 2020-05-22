while (itineration < numberEditions) {
    System.out.println("\nEnter the city and year of the Edition you would"
            + " like to create: ");

    System.out.println("Year: ");
    newYear = scan.nextInt();

    scan.nextLine();

    System.out.println("City: ");
    newCity = scan.nextLine();

    Edition newEdition = new Edition(newCity, newYear);
    editions.add(newEdition);
    itineration++;
}