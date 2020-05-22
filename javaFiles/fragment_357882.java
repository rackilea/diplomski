Classifier cModel = (Classifier)new NaiveBayes();  
cModel.buildClassifier(isTrainingSet);  

weka.core.SerializationHelper.write("/some/where/nBayes.model", cModel);

Classifier cls = (Classifier) weka.core.SerializationHelper.read("/some/where/nBayes.model");

// Test the model
Evaluation eTest = new Evaluation(isTrainingSet);
eTest.evaluateModel(cls, isTrainingSet);