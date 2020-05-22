Test cashPlus = new Test();
do {
    System.out.print("Enter amount:");
    cashMoney = hold.nextDouble();
    cashPlus.addPoints(cashMoney);
    System.out.print("Do you want to enter amount again?(y/n):");
    response = hold.next();

    if(response.equalsIgnoreCase("n")){
        System.out.print("TOTAL: " + cashPlus.getMoney());
    }
} while(response.equalsIgnoreCase("y"));