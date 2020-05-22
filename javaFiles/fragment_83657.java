int step = 0;
for (int i = 0; i < numbers; i++) {
      for (int j = 1; j < (numbers - i); j++) {
          if (arr[j - 1] > arr[j]) {
              //swap elements
              System.out.println("step #" + step + ". swapping " + arr[j - 1] + " and " + arr[j])
              temp = arr[j - 1];
              arr[j - 1] = arr[j];
              arr[j] = temp;
              step++;
          }

      }
}