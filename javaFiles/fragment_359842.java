int knapsack(int weights[], int loads[], int capacity, int index) {
  //no more boxes or exactly out of capacity, return 0 additional boxes
  if( index >= weights.length || capacity == 0) {  
    return 0;
  }

  //capacity exceeded, we need to remove the previous box so we return -1
  if( capacity < 0 ) {
    return -1;
  }

  //"add" branch: since we added 1 box we add 1 to the result of the subtree 
  //(which could be -1 if we exceeded the capacity and thus the result would be 0).
  int resultIfAdded = knapsack(weights, loads, 
                              //the rest capacity is the current capacity minus the current box' weight
                              //or the current box' load if it is lower
                              Math.min( capacity - weights[index], loads[index]), 
                              index + 1 ) + 1;

  //"skip" branch, we just increase the index
  int resultIfSkipped = knapsack(weights, loads, capacity, index + 1 );        

  //we want the highest number of boxes we can stack so return the maximum of both branches
  return Math.max( resultIfAdded, resultIfSkipped );
}