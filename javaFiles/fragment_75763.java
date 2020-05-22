public static void scanExpression(Scanner scan) {

        System.out.println("Please enter a number:");

        try {
            String exp = scan.nextLine();
            if(exp.equals("exit"))
                System.exit(0);
            int result = Integer.parseInt(exp);
            tenMultiplication(result);
        } catch (NumberFormatException e) {scanExpression(scan);}

}

public static void main(String args[]) throws Exception {

    Scanner scan = new Scanner(System.in);
    scanExpression(scan);
}