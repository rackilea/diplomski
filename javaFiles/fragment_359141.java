String datasetName = "weather.nominal";
Instances data = DataSetHelper.getInstanceFromFile("data/" + datasetName + ".arff");

// weka.classifiers.trees.J48 -C 0.25 -M 2
String classifierFullName = "weka.classifiers.trees.J48"
String optionString = " -C 0.25 -M 2"

AbstractClassifier classifier = (AbstractClassifier) Class.forName(classifierFullName).newInstance();

classifier.setOptions(Utils.splitOptions(optionString));
classifier.buildClassifier(data); // build classifier


String modelFullFileName = Finals.MODELS_SAVE_FOLDER + classifier.getClass().getName()  + ".model";
SerializationHelper.write(modelFullFileName, classifier);