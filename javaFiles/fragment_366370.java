package com.stackoverflow.candied_orange;
import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.*;
public class FractalSquareIterative {

    public static void main(String[] args) throws IOException{

        final int SIDE = 1000; // image is SIDE X SIDE        
        BufferedImage image = new BufferedImage(SIDE,SIDE,BufferedImage.TYPE_INT_RGB);

        drawImage(SIDE, image);
        saveImage(image);
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