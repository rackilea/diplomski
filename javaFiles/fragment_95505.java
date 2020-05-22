if (operation == '+')
            if (arg1.equals("")) {
                ergebnis += new Integer(arg2);
            } else {
                ergebnis = new Integer(arg1) + new Integer(arg2);
            }

        else if (operation == '-') {
            if (arg1.equals("")) {
                ergebnis -= new Integer(arg2);
            } else {
                ergebnis = new Integer(arg1) - new Integer(arg2);
            }
        }