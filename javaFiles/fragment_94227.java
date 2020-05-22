public class MyCustomIterator implements DataSetIterator {
    private INDArray inputs, desiredOutputs;
    private int itPosition = 0; // the iterator position in the set.

    public MyCustomIterator(float[] inputsArray,
                            float[] desiredOutputsArray,
                            int numSamples,
                            int inputDim,
                            int outputDim) {
        inputs = Nd4j.create(inputsArray, new int[]{numSamples, inputDim});
        desiredOutputs = Nd4j.create(desiredOutputsArray, new int[]{numSamples, outputDim});
    }

    public DataSet next(int num) {
        // get a view containing the next num samples and desired outs.
        INDArray dsInput = inputs.get(
            NDArrayIndex.interval(itPosition, itPosition + num),
            NDArrayIndex.all());
        INDArray dsDesired = desiredOutputs.get(
            NDArrayIndex.interval(itPosition, itPosition + num),
            NDArrayIndex.all());

        itPosition += num;

        return new DataSet(dsInput, dsDesired);
    }

    // implement the remaining virtual methods...

}