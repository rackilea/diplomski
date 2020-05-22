int[] diceFrequency = new int[6];

//assuming d is in the range [1,6]
for( int d : dice ) {
  //increment the counter for the dice value
  diceFrequency[d-1]++; 
}

int numberOfPairs = 0;
int pairSum = 0;

for( int i = 0; i < diceFrequency.length; i++ ) {
  //due to integer division you get only the number of pairs, 
  //i.e. if you have 3x 1 you get 1 pair, for 5x 1 you get 2 pairs
  int num = diceFrequency[i] / 2;

  //total the number of pairs is just increases
  numberOfPairs += num; 

  //the total value of those pairs is the dice value (i+1) 
  //multiplied by the number of pairs and 2 (since it's a pair)
  pairSum += (i + 1 ) * 2 * num;
}

if( numerOfPairs >= 2 ) {
  //you have at least 2 pairs, do whatever is appropriate
}