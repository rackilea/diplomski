public class RunnableTestClass implements Serializable, Runnable {

private FSTObjectOutput out;
private ObjectOutputStream stream;
private TestClass object;

public RunnableTestClass(long i, ThreadLocal<FSTConfiguration> conf) throws Exception {
    object = new TestClass(i);
    stream = new ObjectOutputStream(new FileOutputStream("out/FST.ser_parallel"));
    out = conf.get().getObjectOutput(stream);
}

@Override
public void run() {
    try {
        out.writeObject(object, TestClass.class);
        out.flush();
        stream.close();
    } catch (IOException e) {
        System.out.println(e);
    }
}