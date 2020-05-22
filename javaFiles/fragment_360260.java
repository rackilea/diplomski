boolean again = true;
do {
    ...
    System.out.println("Again? (y/n)");
    again = Character.toUpperCase(in.next().charAt(0)) == 'Y';
} while (again);