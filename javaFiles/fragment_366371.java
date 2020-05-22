private static void drawFractal(Square square, BufferedImage image){

        Queue<Square> squares = new LinkedList<>();
        squares.add(square);

        while (squares.size() > 0) {

            //Consume
            square = squares.remove();

            //Produce
            int half = square.half();
            if (half > 2) {

                int left = square.left();
                int top = square.top();
                int right = square.right();
                int bottom = square.bottom();
                int newColor = square.color - 100000;                

                squares.add(new Square(left, top, half, newColor));
                squares.add(new Square(left, bottom, half, newColor));
                squares.add(new Square(right, top, half, newColor));
                squares.add(new Square(right, bottom, half, newColor));
            }
            square.draw(image);
        }
    }


    protected static void saveImage(BufferedImage image) throws IOException {
        String fileOut = "helloSquares.png";        
        File outputfile = new File(fileOut);
        ImageIO.write(image, "jpg", outputfile);
    }
} //End FractalSquareIterative