double[][] outputs = null;
for(int i = 0; i < 1; i++){
  inputLayer = trainingInputs;
  outputs = sigmoid(dot(inputLayer, synapticWeights));
}
System.out.println("Outputs after training are: " + Arrays.toString(outputs));