public static void findSquareRoot(double number) {
    MainGUI obj = null;
    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            obj = new MainGUI();
        }
    });

    boolean isPositiveNumber = true;
    double g1;

    //if the number given is a 0
    if (number == 0) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                obj.myTextField.setTest("Square root of " + number + " = " + 0);
            }
        });
    } //If the number given is a -ve number
    else if (number < 0) {
        number = -number;
        isPositiveNumber = false;
    }

    //Proceeding to find out square root of the number
    double squareRoot = number / 2;
    do {
        g1 = squareRoot;
        squareRoot = (g1 + (number / g1)) / 2;
    } while ((g1 - squareRoot) != 0);

    //Displays square root in the case of a positive number
    if (isPositiveNumber) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                obj.append("Square roots of " + number + " are ");
                obj.append("+" + squareRoot);
                obj.append("-" + squareRoot);
            }
        });
    } //Displays square root in the case of a -ve number
    else {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                obj.append("Square roots of -" + number + " are ");
                obj.append("+" + squareRoot + " i");
                obj.append("-" + squareRoot + " i");
            }
        });
    }

}