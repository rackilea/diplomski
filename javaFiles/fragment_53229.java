public class ClassThatDoesStuff {
    private ThingConnector connector;
    private TimeHelper timeHelper;

    public ClassThatDoesStuff(ThingConnector connector) {
        this(connector, new TimeHelper());
    }

    ClassThatDoesStuff(ThingConnector connector, TimeHelper timeHelper) {
        this.connector = connector;
        this.timeHelper = timeHelper;
    } 
}