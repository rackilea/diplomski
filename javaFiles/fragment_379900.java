lotteryNumberFinal = "";
for(int i=0; i < 3; i++) {
        lotteryNumber = (int)(Math.random()*10);
        System.out.print(lotteryNumber);

        lotteryNumberFinal += lotteryNumber;
    } 

System.out.println(lotteryNumberFinal);