public class MyClass
{ 

    // main is a method just like GetArray, defined inside class

    public static void main(String[] args)
    {
          // do something
    }

    // other methods are defined outside main but inside the class.

    public int[][] GetArray() {

            int width = 5;   // change these to your dimensions
            int height = 5;

            int[][] array = new int[width][height]; 

            int q,p;

            for(q=0;q<width;q++)
            {
                 for(p=0;p<height;p++)
                 {
                     array[q][p] = raster.getSample(p, q, 0);
                 }
            }

        return array;
    }   
}