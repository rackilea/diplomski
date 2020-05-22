for(int i = -4; i <= 4; i++){
    for(int j = -4; j <= 4; j++){
        if(bobby.x + i < 0 || bobby.x + i > map.length - 1 || bobby.y + j < 0 || bobby.y + j > map[0].length - 1) continue;
        g.drawImage(imageManager.returnImage(map[bobby.x+i][bobby.y+j],(i+4)*horizontalDifference,(j+4)*verticalDifference,rootPane);
    }
}