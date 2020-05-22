public interface SwitchTypeFactory {
   SwitchType<?> create(String memberName);
}

...

private static Map<String, SwitchTypeFactory> factories = new HashMap<String, SwitchTypeFactory>();

static {
   factories.put("java.lang.String", new SwitchTypeFactory() {
        @Override
        public SwitchType<?> create(String memberName) {
            return new SwitchInputType<String>(memberName + " ");
        }
    });

    factories.put("char", new SwitchTypeFactory() {
        @Override
        public SwitchType<?> create(String memberName) {
            return new SwitchInputType<Character>(Character.valueOf('a'))
        }
    });
    ...
}

public static SwitchType<?> switchT(final String typeName, final String memberName) {
    return factories.get(typeName).create(memberName);
}