enum COLOR { BLUE, GREY, WHITE}; 

boolean select = false;

// iterate row by row
for(int x = 0; x < 8; x++) {
       for(int y = 0; y <8; y++) {
           //select mode...
           if(dots[x][y].color == COLOR.BLUE  && !change) {
                select = true;
           }
           //if we are in select and the current field is white -> make GREY
           if(select && dots[x][y].color == COLOR.WHITE) {
                dots[x][y].color = COLOR.GREY;
           }
           // if we hit another blue and are in select -> select = false
           if(select && dots[x][y].color == COLOR.BLUE) {
                select = false;
           }
    }
}