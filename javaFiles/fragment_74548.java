public static void main(String[] args) {

    int numSeats = 20;
    int available = numSeats;
    int numGroups = 6;

    int groupSizes[] = new int[numGroups];

    groupSizes[0] = 2;
    groupSizes[1] = 1;
    groupSizes[2] = 5;
    groupSizes[3] = 3;
    groupSizes[4] = 10;
    groupSizes[5] = 2;

    for (int i=0; i < groupSizes.length; i++) {

        if (available > groupSizes[i]){
            available -= groupSizes[i];
            System.out.println("Group: " + i + " has been book on!");
        }

        else {
            System.out.println("Not enough seats for group: " + i);
        }

    }
    System.out.println(available + " Seats remaining");
}