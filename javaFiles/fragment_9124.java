package classification;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
weka.filters.supervised.instance.SMOTE
public class questStackoverflow {
public static void main(String agrs[]) throws Exception{
String fileRootPath = "../file.arff"; //Dataset
Instances strdata = DataSource.read(fileRootPath); //Load Dataset
StringToWordVector filter = new StringToWordVector(10000);
filter.setInputFormat(strdata);
String[] options = { "-W", "10000", "-L", "-M", "1",
        "-stemmer", "weka.core.stemmers.IteratedLovinsStemmer", 
        "-stopwords-handler", "weka.core.stopwords.Rainbow", 
        "-tokenizer", "weka.core.tokenizers.AlphabeticTokenizer" 
        };
filter.setOptions(options);
filter.setIDFTransform(true);
Instances data = Filter.useFilter(strdata,filter); //Apply filter
data.setClassIndex(0); //set class index        
double recall=0.0;
double precision=0.0;
double fmeasure=0.0;
double tp, fp, fn, tn;

Classifier classifier = null;
classifier = new NaiveBayesMultinomial(); //classifer

int folds = 10;         
Random random = new Random(1);
data.randomize(random);
data.stratify(folds);
tp = fp = fn = tn = 0;
for (int i = 0; i < folds; i++) {
   Instances trains = data.trainCV(folds, i,random); //training dataset
   Instances tests = data.testCV(folds, i); //testing dataset
   SMOTE smote=new SMOTE();
   smote.setInputFormat(trains);        
   Instances Trains_smote = Filter.useFilter(trains, smote);

    classifier.buildClassifier(Trains_smote);    //build classifier           
    for (int j = 0; j < tests.numInstances(); j++) {    
       Instance instance = tests.instance(j);
       double classValue = instance.classValue();                   
       double result = classifier.classifyInstance(instance);
        if (result == 0.0 && classValue == 0.0) {
                tp++;
            } else if (result == 0.0 && classValue == 1.0) {
                fp++;
            } else if (result == 1.0 && classValue == 0.0) {
                fn++;
            } else if (result == 1.0 && classValue == 1.0) {
                tn++;
            }
        }   
    }

    if (tn + fn > 0)
        precision = tn / (tn + fn);
    if (tn + fp > 0)
        recall = tn / (tn + fp);
    if (precision + recall > 0)
        fmeasure = 2 * precision * recall / (precision + recall);
    System.out.println("Precision: " + precision);
    System.out.println("Recall: " + recall);
    System.out.println("Fmeasure: " + fmeasure);

}