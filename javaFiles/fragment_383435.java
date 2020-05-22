public static void main(String[] args) {
    int g = 1;
    Scanner input = new Scanner(System.in);
    do {
        try {
            System.out.println("Please enter the number you want the table for: \n");
            int z = Integer.parseInt(input.nextLine());
            System.out.println("Upto what number you want the table:\n");
            int y = Integer.parseInt(input.nextLine());
            Solve multiplyObj = new Solve();
            multiplyObj.multiply(z, y);
            g = 2;
        } catch (InputMismatchException e) {
            System.out.println("Error -- input again");
        }catch (Exception e) {
            System.out.println("Error -- input again");
        }           
    }while (g == 1);
    input.close();
}