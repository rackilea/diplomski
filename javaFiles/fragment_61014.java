public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) { // infinity loop, because you want ask many times
        System.out.print("Which line number of pascal's triangle ? ");
        int rowToCompute = scanner.nextInt();
        System.out.println("Line " + rowToCompute + " of Pascal's Triangle is " + Arrays.toString(computeRow(rowToCompute)));

        System.out.println("Another (y/n)?");
        String another = scanner.next();

        if (!another.equalsIgnoreCase("y")) { // if answer is other then 'y', break the loop
            break;
        }
    }
}