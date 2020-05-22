void setup() {
  int[] input = getInput(1000);

  int start = millis();
  bubbleSort(input);
  int elapsed = millis() - start;
  println("Elapsed: " + elapsed);
  exit();
}

int[] getInput(int n) {
  int[] input = new int[n];

  for (int i = 0; i < n; i++) {
    input[i] = (int)random(n);
  }

  return input;
}

int[] bubbleSort(int[] input) {

  boolean swapped = true;
  int j = 0;
  int tmp;
  while (swapped) {
    swapped = false;
    j++;
    for (int i = 0; i < input.length - j; i++) {                                       
      if (input[i] > input[i + 1]) {                          
        tmp = input[i];
        input[i] = input[i + 1];
        input[i + 1] = tmp;
        swapped = true;
      }
    }
  }
  return input;
}