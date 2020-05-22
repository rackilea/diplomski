public class MyClassifier {

    @Classifier
    public String classify(Pojo Pojo) {
        return Pojo.getType();
    }
}