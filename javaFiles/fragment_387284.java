double minimum = array1[0]; //sets the first to be the smallest
var minValueCounter = 0;
for (int i = 0; i < array1.length; i++) //goes through your array
{
 if (array1[i] < minimum) //checks and replaces if necessary
 {
    minimum = array[i];  
    minValueCounter  = 1; 

 }
 else if (array1[i] == minimum) //checks and replaces if necessary
 {
    minValueCounter++;

 }
}