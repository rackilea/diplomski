public enum MyEnum {
    One {
        public int getMemberVariableFailes() {
            // error: non-static variable memberVariable cannot be referenced from a static context
            return memberVariable;
        }

        public int getMemberVariable2OK() {
            return memberVariable2;
        }

        public int getMemberVariableOK() {
            return super.memberVariable;
        }
    };

    private final int memberVariable = 1;
    final int memberVariable2 = 1;
}