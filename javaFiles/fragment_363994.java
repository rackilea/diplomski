for(int i = 0; i < numberOfTestImages; i++) {

   double[] target = new double[]{testLabelBuffer.get()& 0xFF};
   double[] inputs = new double[testRows*testCols];
   or(int j = 0; j < inputs.length; j++) {
   // Normalize input from 0-255 to 0-1
   double temp = (testImageBuffer.get() & 0xFF) / 255f;
   inputs[j] = temp;
 }
 Data tobj = new Data(inputs, target);
 testData.add(tobj);
}