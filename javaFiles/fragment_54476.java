@Test
public void rabbitmqSourceTest() throws InterruptedException {
    AtomicInteger eventCount = new AtomicInteger(0);
    String siddhiApp = "@App:name('TestExecutionPlan') "
            + "define stream FooStream (test string); "
            + "@info(name = 'query1')  "
            + "@source(type ='rabbitmq', "
            + "uri = 'amqp://guest:guest@172.17.0.2:5672', "
            + "exchange.name = 'amq.topic', "
            + "exchange.type = 'topic', "
            + "routing.key= '#',"
            + "queue.name = 'siddhi-queue', "
            + "@map(type='text')) "
            + "define stream BarStream (test string); ";
    SiddhiManager siddhiManager = new SiddhiManager();
    SiddhiAppRuntime siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(siddhiApp);
    siddhiAppRuntime.addCallback("BarStream", new StreamCallback() {
        @Override
        public void receive(Event[] events) {
            for (Event event : events) {
                EventPrinter.print(event);
                eventCount.incrementAndGet();
            }
        }
    });
    siddhiAppRuntime.start();
    SiddhiAppRuntime executionPlanRuntime = siddhiManager.createSiddhiAppRuntime(
            "@App:name('TestExecutionPlan') " +
                    "define stream FooStream (test string); " +
                    "@info(name = 'query1') " +
                    "@sink(type ='rabbitmq', uri = 'amqp://guest:guest@172.17.0.2:5672', " +
                    "exchange.type='topic', " +
                    "exchange.name = 'amq.topic', " +
                    "@map(type='text'))" +
                    "Define stream BarStream (test string);" +
                    "from FooStream select test insert into BarStream;");
    InputHandler fooStream = executionPlanRuntime.getInputHandler("FooStream");
    executionPlanRuntime.start();
    List<Event> arrayList = new ArrayList<Event>();
    arrayList.add(new Event(System.currentTimeMillis(), new Object[]{"WSO2"}));
    arrayList.add(new Event(System.currentTimeMillis(), new Object[]{"IBM"}));
    arrayList.add(new Event(System.currentTimeMillis(), new Object[]{"WSO2"}));
    fooStream.send(arrayList.toArray(new Event[3]));
    SiddhiTestHelper.waitForEvents(waitTime, 3, eventCount, timeout);
    executionPlanRuntime.shutdown();
    siddhiAppRuntime.shutdown();
}