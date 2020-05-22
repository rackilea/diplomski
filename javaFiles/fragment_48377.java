public class MyJRDataSource implements JRDataSource {
    private final testClass data;

    public MyJRDataSource(testClass data) {
        this.data = data;
    }

    @Override
    Object getFieldValue(JRField field) {
        // get value of field here
    }

    @Override
    boolean next() {
        // move to next row of data
    }
}