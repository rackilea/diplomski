public class Test {
    private boolean boolValue;

    @Resource(name = "java:global/myBooleanValue")
    private void setBoolValue(String: strVal) {
         boolValue = Boolean.parseBoolean(strVal);
    }
}