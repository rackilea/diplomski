int[] anArray; //use this array to save all showed question
anArray = new int[10];     

int i = 0;
//set what variable you want to represent random vars
randomint = randomGenerator.nextInt(10); 

do{

   if(i > 0){ 
       //if there is min. 1 value in the array check if the next 
       //random value was already in the array
       while(Arrays.asList(anArray).contains(randomint) == true){
           randomint = randomGenerator.nextInt(10); 
       }
   }
   anArray[i] = randomint; //save the new value for the next checking
   i++;
   System.out.println(randomint);

   //the Question if statements goes here...
}while (i !=10);