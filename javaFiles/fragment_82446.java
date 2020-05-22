while(diceSum!=7){
            diceSum=0;
            dice1=1 + (int)(Math.random() * ((6 - 1) + 1));
            dice2=1 + (int )(Math.random() * ((6 - 1) + 1));
            diceSum=dice1+dice2;
            if (diceSum !=7) {
                theSum=theSum+diceSum;
            }
        }
        if (theSum>finalSum){
            finalSum=theSum;
        }
        if (theSum<lowest){
            lowest=theSum;
        }