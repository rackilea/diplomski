String datasetName = "weather.nominal.only.header";
Instances data = DataSetHelper.getInstanceFromFile("data/" + datasetName + ".arff");



Instance inst = new DenseInstance(data.numAttributes()); 

inst.setDataset(data);

inst.setValue(0, 1); 
inst.setValue(1, 2); 
inst.setValue(2, 0); 
inst.setValue(3, 1); 

println(inst)



Classifier cls = (Classifier) SerializationHelper.read("models/weka.classifiers.trees.J48.model");
double prediction = cls.classifyInstance(inst);

println("prediction as double: " + prediction);
println("prediction as name: " + data.classAttribute().value((int) prediction));