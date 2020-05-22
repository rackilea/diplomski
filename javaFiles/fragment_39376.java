case 'Y':
    System.out.print("Please select a movie: ");
    number = scan.nextInt();
    System.out.println("You have Selected "+movies[number-
        1].substring(3,movies[number-1].length()));
    getSeats();
    break;