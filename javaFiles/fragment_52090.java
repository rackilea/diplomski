public static void main(String []args)
   {
   String [][] theArray = 
            {
             {"word1", "3.5"},
             {"word2", "2.4"},
             {"word3", "1.2"},
             {"word4", "0.5"},
             {"word5", "0.2"}
            };

    String newArray[][]=binArray(theArray,2);
    for(String []ar : newArray)
     {
       System.out.println(ar[0] + " " + ar[1]);
     }
   }

   public static String [][]binArray(String [][]theArray,int theBinningNumber)
   {
    //Determine the size (length) of new array
    int newSize=theArray.length/theBinningNumber;
    if(theArray.length % theBinningNumber !=0)
       {
       newSize++;
       }

     //Define new array 
     String [][]newArray=new String[newSize][];
     int theNewIndex=0;

     for(int index=0;index<theArray.length;index+=theBinningNumber)
      {
          String []ar=new String[] {"",""};  
          double value=0;
          for(int binIndex=index;
                   binIndex<(index+theBinningNumber) 
                            && binIndex<theArray.length;
                                            binIndex++)
           {
               value = value + Double.parseDouble(theArray[binIndex][1]);
               ar[0]=ar[0] + " " + theArray[binIndex][0];
               ar[1]=String.valueOf(value);
            }
          newArray[theNewIndex++]=ar;
       }
      return newArray;        
   }