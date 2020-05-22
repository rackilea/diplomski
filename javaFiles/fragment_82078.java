int counter = 0;
   Collections.shuffle(randomList);
    for (int i = 0; i < blocks.length; i++){
        for (int j = 0; j < blocks[i].length; j++){
            blocks[i][j] = randomList.get(counter);
            counter++; 
        }
    }