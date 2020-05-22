public class PairedLearnersExample {

    public static void main(String[] args) {

        ArffFileStream fs = new ArffFileStream(PairedLearnersExample.class.getResource("abalone.arff").getFile(), -1);
        fs.prepareForUse();

        PairedLearners learners = new PairedLearners();

        BasicClassificationPerformanceEvaluator evaluator = new BasicClassificationPerformanceEvaluator();

        EvaluatePrequential task = new EvaluatePrequential();
        task.learnerOption.setCurrentObject(learners);
        task.streamOption.setCurrentObject(fs);
        task.evaluatorOption.setCurrentObject(evaluator);

        task.prepareForUse();

        LearningCurve le = (LearningCurve) task.doTask();

        System.out.println(le);

    }

}