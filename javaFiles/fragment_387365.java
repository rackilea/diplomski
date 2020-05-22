public float[] sampleFromNetwork(INDArray priori, int numTimeSteps){
    int inputCount = this.getNumOfInputs();
    float[] samples = new float[numTimeSteps];

    if(priori.size(1) != inputCount) {
        String format = String.format("the priori should have the same number of inputs [%s] as the trained network [%s]", priori.size(1), inputCount);
        throw new RuntimeException(format);
    }
    if(priori.size(2) < inputCount) {
        String format = String.format("the priori should have enough timesteps [%s] to prime the new inputs [%s]", priori.size(2), inputCount);
        throw new RuntimeException(format);
    }

    this.network.rnnClearPreviousState();
    INDArray output = this.network.rnnTimeStep(priori);

    output = output.ravel();
    // Store the output for use in the inputs
    LinkedList<Float> prevOutput = new LinkedList<>();
    for (int i = 0; i < output.length(); i++) {
        prevOutput.add(output.getFloat(0, i));
    }

    for( int i=0; i<numTimeSteps; ++i ){
        samples[i] = (prevOutput.peekLast());
        //Set up next input (single time step) by sampling from previous output
        INDArray nextInput = Nd4j.zeros(1,inputCount);

        float[] newInputs = new float[inputCount];
        newInputs[inputCount-1] = prevOutput.peekLast();
        for( int j=0; j<newInputs.length-1; j++ ) {
            newInputs[j] = prevOutput.get(prevOutput.size()-inputCount-j);
        }

        nextInput.assign(Nd4j.create(newInputs)); //Prepare next time step input
        output = this.network.rnnTimeStep(nextInput); //Do one time step of forward pass
        // Add the output to the end of the previous output queue
        prevOutput.addLast(output.ravel().getFloat(0, output.length()-1));
    }
    return samples;
}