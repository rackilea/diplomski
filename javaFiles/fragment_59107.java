public void generateNumbers()
{

   for(int counter=0; counter< 6; counter++){

       numbers[counter]= 1+ (int)(Math.random()*49);
       for(int y = counter - 1; y >=0 ; y--){
           if(numbers[counter] == numbers[y]){
               numbers[counter]= 1+ (int)(Math.random()*49);
               y = counter - 1; // <<<===== ADDED
            }
       }


}