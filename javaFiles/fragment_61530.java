double dAllowance;
String strDAllowance;

for ( ; ; ) {
    strDAllowance = JOptionPane.showInputDialog(/* ~~~ */);

    try {
        dAllowance = Double.parseDouble(strDAllowance);

        if (dAllowance > 0) {
            break;

        } else if (dAllowance == 0) {
            System.exit(0);
        }
    } catch (NumberFormatException e) {}

    /* notify and automatically continues */
}