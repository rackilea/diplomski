for(int i = 0; i < COL; i++){
        for(int j = 0; j < ROWS; j++){

           g.setColor(Color.BLUE);
           g.fillRect( (i*SQUARE_SIZE),(j * SQUARE_SIZE+SQUARE_SIZE),SQUARE_SIZE,SQUARE_SIZE);     

           if(board[i][j] == 0){
              g.setColor(Color.BLACK);
              g.fillOval( (i*SQUARE_SIZE),(j*SQUARE_SIZE +SQUARE_SIZE),CIRCLE_WIDTH_HEIGHT,CIRCLE_WIDTH_HEIGHT);                  

           }else if(board[i][j] == 1){

              g.setColor(Color.RED);
              g.fillRect( (i*SQUARE_SIZE),(j * SQUARE_SIZE+SQUARE_SIZE),SQUARE_SIZE,SQUARE_SIZE);                     

           }else if(board[i][j] == 2){ 

              g.setColor(Color.YELLOW);
              g.fillOval( (i*SQUARE_SIZE),(j*SQUARE_SIZE +SQUARE_SIZE),CIRCLE_WIDTH_HEIGHT,CIRCLE_WIDTH_HEIGHT);

           }
        }
     }