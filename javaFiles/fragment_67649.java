public class JmsDestinationAttributes implements JmsDestinationAttributesMBean {
    protected final String name;
    protected final Random random = new Random(System.currentTimeMillis());
    public JmsDestinationAttributes(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getMessagesCurrentCount() {
        return Math.abs(random.nextInt(100));
    }

    public int getConsumersCurrentCount() {
        return Math.abs(random.nextInt(10));
    }
}