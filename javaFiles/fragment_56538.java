Random rnd = new Random();

//shuffle rows/cols
for(int x=0; x<myArray.length; x++)
{
   int idx = rnd.nextInt(myArray.length);
   if(idx != x){
       int[] temp = myArray[x];
       myArray[x] = myArray[idx];
       myArray[idx] = temp;
   }
}