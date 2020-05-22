/*somewhere in your code to determine whether you add or subtract,  
  have a button or something which changes this value.
*/
boolean isAdding = true;

//...

//button pressed
isAdding = false;

//...

//your calculating code goes here
if(isAdding)
    totalResult += result;
else
    totalResult -= result;

//all of the other stuff