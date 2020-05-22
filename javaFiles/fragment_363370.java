public class ChannelComponent {

    private String name;
    private String mode; //(1P1C / XPXC / 1PXC)
    private List<SourceProvidedPort> publishers = new ArrayList<SourceProvidedPort>();
    private List<SinkRequiredPort> subscribers = new ArrayList<SinkRequiredPort>();
    private TestCentralRegistry testCentralRegistry;

    public ChannelComponent(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }

    public void registerTestCentralRegistry( TestCentralRegistry testCentralRegistry) {
        this.testCentralRegistry = testCentralRegistry;
    }
}