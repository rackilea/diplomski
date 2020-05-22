int b = 0;
    Random rn = new Random();
    for (int i=0;i<7;i++){

        b = rn.nextInt(4);
        String[] colors = {"green","red","gold","brown"};

        Card card = new Card((short) (rn.nextInt((14 - 7) + 1) + 7),colors[b]);

        System.out.println("Adding card to hand: " + 
             card.getColor() + card.getValue() + " to: " +i);

        hand.add(card);
    }