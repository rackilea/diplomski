// Careful... still buggy!
    for(int i = 0; i < suits.length; i++) {
        for(int n = 0; n < ranks.length; n++) {
            cards[i * ranks.length + n] = new Card(ranks[i],suits[n]);
        }
    }