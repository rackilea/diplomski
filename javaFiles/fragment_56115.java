String textA = showInputDialog("Enter first number: ");
        String textB = showInputDialog("Enter second number: ");
        int a = parseInt(textA);
        int b = parseInt(textB);
        switch(c) {
        case 1:
            showMessageDialog(null, a + " + " + b + " = " + (a+b));
            break;

        case 2:
        ...
        default:
            showMessageDialog(null, "You cant do that.");