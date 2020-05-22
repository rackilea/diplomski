Boolean breaking = false;
for(int row = 0; row < newArray.length; row++){
for (int col = 0; col < newArray[row].length; col++){
if (newArray[row][col] < 0){
//Number is negative
   breaking = true; // Variable to break out of outer loop
   break;

}
}  //inner for loop scope ends here
if(breaking)
{
    break;
}

}