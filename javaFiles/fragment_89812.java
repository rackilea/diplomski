static int migratoryBirds(List<Integer> arr) {
    int[] birdCountArr = new int[6]; // bird numbers are guaranteed to be between [1,5], we ignore index 0.
    for(int n : arr) {
      birdCountArr[n]++;
    }
    int high = 0;
    int highBirdNum = 0;
    for(int i = 1; i < birdCountArr.length; i++) {
      if(birdCountArr[i] > high) {
        high = birdCountArr[i];
        highBirdNum = i;
      }
    }
    return highBirdNum;
  }