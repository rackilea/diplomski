public class Run {
    public static void main(String[] args) throws Exception {

        ConverterUtils.DataSource source1 = new ConverterUtils.DataSource("./data/train.arff");
        Instances train = source1.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
        if (train.classIndex() == -1)
            train.setClassIndex(train.numAttributes() - 1);

        ConverterUtils.DataSource source2 = new ConverterUtils.DataSource("./data/test.arff");
        Instances test = source2.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
        if (test.classIndex() == -1)
            test.setClassIndex(train.numAttributes() - 1);

        // model

        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.buildClassifier(train);

        // this does the trick  
        double label = naiveBayes.classifyInstance(test.instance(0));
        test.instance(0).setClassValue(label);

        System.out.println(test.instance(0).stringValue(4));
    }
}