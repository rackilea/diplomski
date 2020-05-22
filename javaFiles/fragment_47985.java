try(Jep jep = new Jep()) {
    // Load model
    jep.eval("import pickle");
    jep.eval("with open('Randomforestclassifier.pkl', 'rb'): as f: clf = pickle.load(f)");
    Object randomForest = jep.getValue("clf");

    ...

    // Then in another context you can pass your model to your function
    jep.eval("import predictionModule");
    jep.set("arg", randomForest);
    jep.eval("result = predictionModule.use(arg)");
    Object result = jep.getValue("result");
}