int roll1 = 2; // Two made
int roll2 = 5; // up numbers
/* Note that the index will be one off from the reflected number.
You may want to subtract 1 from your random number or put a blank die at index 0
*/

for(int x=0; x<dice[roll1].length; x++){
  System.out.println(dice[roll1][x] + " " + dice[roll2][x]);
}