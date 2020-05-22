SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for(int x = 0; x < 250-squareW; x+=squareX){
                    for(int y = 0; y < 200-squareH; y+=squareY){
                        moveSquare(x,y);
                    }
                }
            }
        });