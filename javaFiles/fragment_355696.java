public void updateTiles(){

    if(changeType == NO_CHANGE){
        //do something
    }
    else if(changeType == BOARD_MOVED){
        repaint();
    }
    else if(changeType == TILE_CHANGED) {
        for(int i = 0; i < changeList.length; i++) {
            for(int j = 0; j < changeList[i].length; j++) {
                if(changeList[i][j]) {
                    repaint(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE );
                    changeList[i][j] = false;
                }
            }
        }
    }

    changeType == NO_CHANGE; 
}