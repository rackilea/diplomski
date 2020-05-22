Coin myCoin = new Coin();
System.out.println("Coin initially is " + myCoin.getSideUp());

int[] coinCount = new int[2];
for (int i = 0; i < 40; i++) {
    myCoin.toss();
    System.out.println("Coin is now " + myCoin.getSideUp());

    if(myCoin.getSideUp().equals("heads")){
        coinCount[0]++;
    } else {
        coinCount[1]++;
    }
}

System.out.println("Heads: "+coinCount[0]);
System.out.println("Tails: "+coinCount[1]);