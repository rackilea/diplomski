public class RingBuffer 
{
   private double[] EmptyBuffer;
   private int size;
   private int capacity;

     public RingBuffer(int capacity){
        EmptyBuffer = new double[capacity];


    }

    public int size(){
        int counter = 0; 
        for(double element : EmptyBuffer){
            if(element != 0) // Testing for null makes no sense! Test for non-zero?
                counter++;
            }

        return counter;
    }