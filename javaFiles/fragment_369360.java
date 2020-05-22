private void drawStones(Graphics2D g2) {
    stones = view.getGame().getLevel().getStones();

    for (int i = 0; i < stones.length; i++) {
        for (int j = 0; j < stones[1].length; j++) {
            int x_position = (int) stones[i][j].getPosition().getX();
            int y_position = (int) stones[i][j].getPosition().getY();
            if(stones[i][j].getType() >= 1) {

                // ********
                int type = stones[i][j].getType();
                Color color = .... set color based on type value here

                // *******

                g2.setColor(stones[i][j].getColor());
                g2.fillRoundRect(x_position, y_position, 
                        (int) ((double)Constants.SCREEN_WIDTH/Constants.SQUARES_X)-2, 
                        (int) ((double)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y)-2 ,1,1);
            }
        }
    }
}