public class Test {
    final ProgressBar bar = new ProgressBar(0.0);
    TextArea area = new TextArea();
    int result;
    final Worker work = new Worker();
    final Worker2 work2 = new Worker2();

// GUI Scene change happens here

    work.setOnSucceeded(e -> work2.doSomething(work.getValue(), area));
    bar.progressProperty().bind(work.progressProperty());
    new Thread(work).start();

}