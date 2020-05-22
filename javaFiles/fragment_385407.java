package com.stackoverflow.candied_orange;
import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.*;
public class InFrontInterative {

    public static void main(String[] args) throws IOException{

        final int SIDE = 1000; // image is SIDE X SIDE        
        BufferedImage image = new BufferedImage(SIDE,SIDE,BufferedImage.TYPE_INT_RGB);

        drawImage(SIDE, image);
        saveImage(image, "helloSquares.png");
    }

    //Removed IO to enable unit testing
    protected static void drawImage(final int SIDE, BufferedImage image) {
        final int BLACK = Color.BLACK.getRGB();
        final int WHITE = Color.WHITE.getRGB();
        final int HALF = SIDE / 2;

        //Draw background on whole image
        new Square(HALF, HALF, SIDE, BLACK).draw(image);

        //Draw foreground starting with centered half sized square
        Square square = new Square(HALF, HALF, HALF, WHITE);
        drawFractal(square, image);
    }

    private static void drawFractal(Square square, BufferedImage image){

        Stack<Square> squares = new Stack<>();
        Queue<Square> breeders = new LinkedList<>();
        breeders.add(square);

        //Produce
        while (breeders.size() > 0) {
            square = breeders.remove();

            int half = square.half();

            if (half > 0) {
                System.out.println(half);//TODO remove debugging code 

                int left = square.left();
                int top = square.top();
                int right = square.right();
                int bottom = square.bottom();
                int newColor = square.color - 100000;                

                breeders.add(new Square(left, top, half, newColor));
                breeders.add(new Square(left, bottom, half, newColor));
                breeders.add(new Square(right, top, half, newColor));
                breeders.add(new Square(right, bottom, half, newColor));
                squares.push(square);   
            }            
        }

        //Consume
        while (squares.size() > 0) {
            square = squares.pop();
            square.draw(image);
        }
    }

    protected static void saveImage(BufferedImage image, String fileOut)
    throws IOException {
        File outputfile = new File(fileOut);
        ImageIO.write(image, "jpg", outputfile);
    }    
}