Random randomCards = new Random();
        int[] card={0,0,0,0,0};
        while(card[card.length-1] == 0) {
            int temp=randomCards.nextInt(52);
            for(int j=0;j< card.length ; j++){
             if(card[j] == 0){
                 card[j] = temp;
                 break;
             }
            }
        }
        for(int j=0;j< card.length ; j++){
         System.out.println(card[j]);
        }