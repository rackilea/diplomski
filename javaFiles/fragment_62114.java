public static void main(String[] args) {
    String initialAmt_Str, targetAmt_Str, interestPct_Str, years_Str, result;
    double principle, target, interest;
    int again, time;

    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    do {
        Object[] options = {"Compute years to reach target",
            "Compute target given number of years"};

        int choice = JOptionPane.showOptionDialog(null, "Please choose what you would like to do.",
                "Investment Advisor", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, null);

        if (choice != JOptionPane.CANCEL_OPTION) {

            again = JOptionPane.YES_OPTION;
            if (choice == 1) {
                String input = JOptionPane.showInputDialog("Enter the principle:", "Investment Advisor");
                if (input != null) {
                    // Process further...
                    System.out.println("Continue processing...");
                } else {
                    again = JOptionPane.NO_OPTION;
                }
            } else if (choice == 0) {
                String input = JOptionPane.showInputDialog("Enter your target amount:", "Investment Advisor");
                if (input != null) {
                    // Process further...
                    System.out.println("Continue processing...");
                } else {
                    again = JOptionPane.NO_OPTION;
                }
            }

            if (again != JOptionPane.NO_OPTION) {
                again = JOptionPane.showConfirmDialog(null, "Find Another?");
            }

        } else {
            again = JOptionPane.NO_OPTION;
        }
    } while (again == JOptionPane.YES_OPTION);
}