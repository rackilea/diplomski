final double[] primitiveArray = ...;

final int len = primitiveArray.length;

final Double[] boxedArray = new Double[len];

for (int index = 0; index < len; index++)
    boxedArray[index] = Double.valueOf(primitiveArray[index]);