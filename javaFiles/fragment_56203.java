double[] movingAverage = { 0.1, 0.2, 1.1, 1.2 };
int offset = 2;

// print before
System.out.println(Arrays.toString(movingAverage));

// remove first offset elements
movingAverage = Arrays.copyOfRange(movingAverage, offset, movingAverage.length);

// print after
System.out.println(Arrays.toString(movingAverage));