public static int hitPoints() { // return type is int, to return an int value
    int hitPoints = 0; // default value
    do {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the hit points for the fighter");
        hitPoints = input.nextInt();
        return hitPoints;
    } while (hitPoints <= 50);
    // return 0; // not required, as its a do-while loop above
}