public class TestCentralRegistry {

    private List<ChannelComponent> channels = new ArrayList<ChannelComponent>();

    public void addChannelComponent(ChannelComponent c) {
        channels.add(c);
    }

    public static void main(String... args) {
        TestCentralRegistry demo = new TestCentralRegistry();

        ChannelComponent cc1 = new ChannelComponent("channel1", "1P1C");
        cc1.registerTestCentralRegistry( demo);
        ChannelComponent cc2 = new ChannelComponent("channel2", "XPXC");
        cc2.registerTestCentralRegistry( demo);

        demo.addChannelComponent( cc1);
        demo.addChannelComponent( cc2);
    }
}