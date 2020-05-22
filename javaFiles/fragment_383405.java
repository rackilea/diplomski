public void getColor()
{
  System.out.println("This picture's dimensions are: "+this.getWidth()+" by "+this.getHeight());
   for (int row=0; row < this.getHeight(); row++) // gives the number of rows
   {

     for (int col=0; col < this.getWidth(); col++)// gives the number of columns
     {
       Pixel pix = this.getPixel(col,row);        
       System.out.print(pix.getRed()+" "+pix.getGreen()+" "+pix.getBlue()+" ");
     } // end of inner loop

    //After this ^^^ for loop runs, you've gone over the whole row.
    System.out.println();
   }// end of outer loop
} // end of method