int indexToRemove = 3;

Object[] newArray = new Object[values.length - 1];

for (int i = 0; i < newArray.length; i++) {
    if (i < indexToRemove) {
        newArray[i] = values[i];
    } else {
        newArray[i] = values[i + 1];
    }
}