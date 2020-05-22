public static int getCredits()
    {
        //declare hours variable
        String input;
        int credits = 0;
        input = JOptionPane.showInputDialog(null,"Number of Credits?");

        return Integer.parseInt(input);
    }