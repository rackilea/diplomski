import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;
import java.awt.Point;
public class EdgeDetection {

    public App ap;
        public int[] horizontalCuts = {120, 220, 320, 420};
        public int[] verticalCuts = {300, 350, 375, 400};



    public void printEdgesTest(BufferedImage image, boolean reversex, boolean reversey, int rangex, int rangey){
        int[] mx = horizontalCuts;
        int[] my = verticalCuts;

            //you are getting edge points here
            //the "true" parameter indicates that it performs a cut starting at 0. (left edge)
        int[] xEdges = getEdges(image, mx, reversex, true);
        int edgex = getEdge(xEdges, rangex);
        for(int x = 0; x < xEdges.length; x++){
            System.out.println("EDGE = " + xEdges[x]);
        }
        System.out.println("THE EDGE = " + edgex);
            //the "false" parameter indicates you are doing your cut starting at the end (image.getHeight)
            //and ending at 0
            //if the parameter was true, it would mean it would start the cuts at y = 0
        int[] yEdges = getEdges(image, my, reversey, false);
        int edgey = getEdge(yEdges, rangey);
        for(int y = 0; y < yEdges.length; y++){
            System.out.println("EDGE = " + yEdges[y]);
        }
        System.out.println("THE EDGE = " + edgey);
    }

    //This function takes an array of coordinates...detects outliers, 
    //and computes the average of non-outlier points.

    public int getEdge(int[] edges, int range){
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] passes = new boolean[edges.length];
        int[][] differences = new int[edges.length][edges.length-1];
        //THIS CODE SEGMENT SAVES THE DIFFERENCES BETWEEN THE POINTS INTO AN ARRAY
        for(int n = 0; n<edges.length; n++){
            for(int m = 0; m<edges.length; m++){
                if(m < n){
                    differences[n][m] = edges[n] - edges[m];
                }else if(m > n){
                    differences[n][m-1] = edges[n] - edges[m];
                }
            }
        }
         //This array determines which points are outliers or nots (fall within range of other points)
        for(int n = 0; n<edges.length; n++){
            passes[n] = false;
            for(int m = 0; m<edges.length-1; m++){
                if(Math.abs(differences[n][m]) < range){
                    passes[n] = true;
                    System.out.println("EDGECHECK = TRUE" + n);
                    break;
                }
            }
        }
         //Create a new array only using valid points
        for(int i = 0; i<edges.length; i++){
            if(passes[i]){
                result.add(edges[i]);
            }
        }

        //Calculate the rounded mean... This will be the x/y coordinate of the edge
        //Whether they are x or y values depends on the "reverse" variable used to calculate the edges array
        int divisor = result.size();
        int addend = 0;
        double mean = 0;
        for(Integer i : result){
            addend += i;
        }
        mean = (double)addend/(double)divisor;

        //returns the mean of the valid points: this is the x or y coordinate of your calculated edge.
        if(mean - (int)mean >= .5){
            System.out.println("MEAN " + mean);
            return (int)mean+1;
        }else{
            System.out.println("MEAN " + mean);
            return (int)mean;
        }       
    }


     //this function computes "dark" points, which include light gray, to detect edges.
     //reverse - when true, starts counting from x = 0 or y = 0, and ends at image.getWidth or image.getHeight()
     //verticalEdge - determines whether you want to detect a vertical edge, or a horizontal edge
     //arr[] - determines the coordinates of the vertical or horizontal cuts you will do
     //set the arr[] array according to the graphical layout of your scanned image
     //image - this is the image you want to detect black/white edges of
    public int[] getEdges(BufferedImage image, int[] arr, boolean reverse, boolean verticalEdge){
        int red = 255;
        int green = 255;
        int blue = 255;
        int[] result = new int[arr.length];
        for(int n = 0; n<arr.length; n++){
            for(int m = reverse ? (verticalEdge ? image.getWidth():image.getHeight())-1:0; reverse ? m>=0:m<(verticalEdge ? image.getWidth():image.getHeight());){
                Color c = new Color(image.getRGB(verticalEdge ? m:arr[n], verticalEdge ? arr[n]:m));
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();
                        //determine if the point is considered "dark" or not.
                        //modify the range if you want to only include really dark spots.
                        //occasionally, though, the edge might be blurred out, and light gray helps
                if(red<239 && green<239 && blue<239){
                    result[n] = m;
                    break;
                }
                        //count forwards or backwards depending on reverse variable
                if(reverse){
                    m--;
                }else{
                    m++;
                }
            }
        }
    return result;
    }

}