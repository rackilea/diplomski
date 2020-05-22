public static void main(String[] args) {
    double wage = Validate.collectWage("Please enter your hourly wage");

}// end main method

public static Double collectWage(String messageIn) {
    Scanner input = new Scanner(System.in);
    String strOut = "";
    boolean valid = true;
    double out = 0;

    System.out.println(messageIn);
    while (valid) {
        try {
            strOut = input.nextLine();
            if (strOut.length() != 3) {
                throw new Exception();
            }
            out = Double.parseDouble(strOut);
            valid = false;
        } catch (NumberFormatException ne) {
            System.out.println("Please enter a valid wage");
        } catch (Exception e) {

            System.out.printf("A wage should be 3 numbers long");
        } //end catch
    } //end while

    return out;


}//end collectWage method