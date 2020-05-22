double[]numbers= {6 , 5 ,7};
    Arrays.sort(numbers);
    // start with last number
    double diff = numbers[numbers.length-1];
    for (int i=numbers.length-2 ; i>= 0; i--) {
      // substract other number one by one  
      diff-=numbers[i];
    }
    System.out.println("Answer --> "+diff);