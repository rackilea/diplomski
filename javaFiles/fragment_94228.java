MyCustomIterator it = new MyCustomIterator(
    inputs,
    desiredOutputs,
    numSamples,
    inputDim,
    outputDim);

for (int epoch = 0; epoch < nEpochs; epoch++)
    model.fit(it);