private void shuffleImageResourceIds() {
    Random random = new Random();
    for (int x = gameGrid.length - 1; x >= 0; x--) {
        for (int y = gameGrid[x].length - 1; y >= 0; y--) {
            int size = images.size();
            if(size > 1){
                int index = random.nextInt(size);
                int imageResourceId = images.valueAt(index);
                images.removeAt(index);
                gameGrid[x][y].setImageResource(imageResourceId);
            }
            else {
                gameGrid[x][y].setImageResource(images.valueAt(0));
            }
        }
    }
}