//adds 4 values to i through the whole song
    int[][] offset  = new int[mp3.getBytes().size()/4][4];
    int counter = 0;
    for(int i = 0; i < mp3.getBytes().size()/4;i++) {
        for(int j = 0; j < 4; j++) {
            offset[i][j] = mp3.getBytes().get(counter);
            counter++;
        }

    }