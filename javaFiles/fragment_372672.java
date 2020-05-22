try
    {
        FileReader reader2 = new FileReader("3.arff"); 
        Instances instances2 = new Instances(reader2);
        instances2.setClassIndex(instances2.numAttributes() - 1);
        reader2.close();
        int numAttr = instances2.numAttributes();

        Instances labeled = new Instances(instances2);
        Classifier cls = (Classifier) weka.core.SerializationHelper.read("/home/sumit/Desktop/weka test/tree.model");
        cls.setDebug(true);

        Instance inst = new Instance(4);
        inst.setValue(0, instances2.instance(0).value(0));
        inst.setValue(1, instances2.instance(0).value(1));
        inst.setValue(2, instances2.instance(0).value(2));
        inst.setValue(3, -1);
        double clsLabelTest = cls.classifyInstance(inst);
        System.out.println(clsLabelTest);

        //instances2.deleteAttributeAt(numAttr-1);
        for(int j=0; j<instances2.numInstances() ;j++)
        {
                //instance temp = new instance(instances2.instance(j));
                instances2.instance(j).setValue(numAttr-1,-1);
                //System.out.println("The instance: " + instances2.instance(j)); 
                double clsLabel = cls.classifyInstance(instances2.instance(j));
                labeled.instance(j).setClassValue(clsLabel);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/sumit/Desktop/weka test/labeled.arff"));           
        writer.write(labeled.toString());
        writer.newLine();
        writer.flush();
        writer.close();
        // Test the model
        //Evaluation eTest = new Evaluation(instances2);
        //eTest.evaluateModel(cls, instances2);
    }