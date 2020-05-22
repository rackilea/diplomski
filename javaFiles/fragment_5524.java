// you don't need following line at all
// int[][] array = ???;

TwoDimArray twoDimArray = new TwoDimArray();

System.out.println("Max value: " + twoDimArray.getArrayMaxValue()); // Max value: 5
System.out.println("Min value: " + twoDimArray.getArrayMinValue()); // Min value: 1

// Average value
System.out.println(getAverage(twoDimArray.arr)); // 3, because 21 / 6 = 3