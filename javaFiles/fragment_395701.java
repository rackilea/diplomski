String test = "0, 1, 3, 2, 2, 1, 1, 4, 2, 5, 1, 1, 0, 1, 241";
String[] testArray = test.split(", ");

int max = Integer.MIN_VALUE, maxIndex = 0;

for (int i = 0; i < testArray.length; i++) {
     if (Integer.parseInt(testArray[i]) > max) {
         max = Integer.parseInt(testArray[i]);
         maxIndex = i;
     }
}