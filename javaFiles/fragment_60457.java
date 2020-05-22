private TensorFlowInferenceInterface inferenceInterface;

public InferenceExample(final Context context) {
    inferenceInterface = new TensorFlowInferenceInterface(assets, model);
}

public synchronized float[] run(float[] data) { ... }