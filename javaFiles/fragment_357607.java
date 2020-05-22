Instances instancesSample = new Instances(structure, 0);
instancesSample.setClassIndex(1);
...
ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("classifier.model"));
oos.writeObject(f);
oos.writeObject(instancesSample);
oos.flush();
oos.close();