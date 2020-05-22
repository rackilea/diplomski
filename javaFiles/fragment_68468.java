for(int i = 0; i<4; i++){
        for(int j = 0; j < 13; j++){
            deckArray[13 * i + j] == image.getSubImage(i * cardWidth,
                                                       j * cardHeight, 
                                                       cardWidth, 
                                                       cardHeight);
        }
    }