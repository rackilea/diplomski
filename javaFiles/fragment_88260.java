for (DoubleTwoDArrayWritable value : values) {
    Writable[][] currentArray = value.get();
    for (int i = 0; i < currentArray.length; i++) {
        for (int j = 0; j < currentArray[i].length; j++) {
             DoubleWritable valueYouWant = (DoubleWritable)currentArray[i][j];
        }
    }
}