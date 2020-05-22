while (
    ( dAllowance = Double.parseDouble(
        JOptionPane.showInputDialog(
            null,
            "Please enter Daily Allowance $:(>0)",
            "Allowance",
            JOptionPane.INFORMATION_MESSAGE)
    ) ) < 0) {
        System.out.println("Daily Allowance shoould be >0. Please enter again.");
}

if (dAllowance == 0) {
    System.out.println(
        "Thank you for using Allowance Calculating Application.");
    System.exit(0);
}