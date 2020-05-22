String bla = "12.25";

    double showWithdrawal = 0;

    try {
        showWithdrawal = Double.parseDouble(bla);
    } catch (Exception e) {
        e.getMessage();
    }

    System.out.println(showWithdrawal);