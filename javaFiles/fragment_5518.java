if(answer.equals("deposit")){
        System.out.println("How much do you want to deposit?");
        double money = in.nextDouble();
        in.nextLine();
        deposit(money);
    }