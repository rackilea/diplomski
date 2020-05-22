private boolean isSum24(int arr[], int targetSum) {
      if(arr.length == 1){
              return arr[0] = targetSum; //base case
      } 
      return isSum24(Arrays.copyOfRange(arr, 1, arr.length), targetSum - arr[0]); //induction step
 }