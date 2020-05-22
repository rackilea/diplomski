interface DataProvider {
    Data getData();
}

interface DataConsumer {
    void method(Data data);
}

class Service {
    private final DataProvider dataProvider;
    private final DataConsumer dataConsumer;

    public Service(DataProvider dataProvider, DataConsumer dataConsumer) {...}

    public void someMethod() {
        Data d = dataProvider.getData();

        try {
            dataConsumer.method(data);
        } catch(Exception e) {

        }
    }
}