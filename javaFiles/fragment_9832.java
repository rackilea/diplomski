public class MyNotEnum {
    // this is the static context in which the anonymous is created
    public static final MyNotEnum One = new MyNotEnum() {
        public int getMemberVariableFailes() {
            // error: non-static variable memberVariable cannot be referenced from a static context
            return memberVariable;
        }

        public int getMemberVariableOK() {
            return super.memberVariable;
        }
    };
    private final int memberVariable = 1;
}