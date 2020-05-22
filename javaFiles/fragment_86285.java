private void drawLineBTrain(Graphics g){

    Graphics2D gg = (Graphics2D) g;
    AffineTransform aT = gg.getTransform(); // We store the initial transformation matrix

    for(int i = 0; i < b.getSize(); i++){            

    if(rotate){
            gg.rotate(-Math.PI/4, b.getCar(i).getPosX(), b.getCar(i).getPosY());
    }

        gg.fillRect(b.getCar(i).getPosX(), b.getCar(i).getPosY(), 80, 24);
        gg.setTransform(aT); // We restore the transformation matrix
    }
}