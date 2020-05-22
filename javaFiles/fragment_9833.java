public class MyNotEnum {
    public class NestedNotEnum extends MyNotEnum {
        public int getMemberVariableFailes() {
            // compiles just fine.
            return memberVariable;
        }

        public int getMemberVariableOK() {
            return super.memberVariable;
        }
    }
    private final int memberVariable = 1;
}