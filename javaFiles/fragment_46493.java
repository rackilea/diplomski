String winner; boolean check;
do {
    System.out.print("\nWho do you think will win?: ");
    winner = sc.nextLine();
    //check if there are a team in your array, with (ignoring cases)
    check = Arrays.asList(teams).stream().anyMatch(winner::equalsIgnoreCase);

} while (!check);

System.out.println(winner);