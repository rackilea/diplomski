ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("classifier.model")));
FilteredClassifier cls = (FilteredClassifier)= (Classifier) objectInputStream.readObject();
Instances instancesSample = (Instances) objectInputStream.readObject();
objectInputStream.close();

int classIndex = 1;
Instances ins = unlabeled[i];
double clsLabel = cls.classifyInstance(ins);
String prediction = instancesSample.attribute(classIndex).value((int) clsLabel));
System.out.println(", predicted: " + prediction);