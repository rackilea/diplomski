for(int i = 0; i<cards.length; i++){
        Card myCard = cards[i];
        value[i] = myCard.getValue();
        if ( value[i] == 1 ) {
           value[i] = 14;
        }
        if(value[i]%2 != 0)
            return false
        }
    }