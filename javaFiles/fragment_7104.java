// Grab size of the byte array, create an array of shorts of the same size
int size = byteArray.length;
short[] shortArray = new short[size];

for (int index = 0; index < size; index++)
    shortArray[index] = (short) byteArray[index];