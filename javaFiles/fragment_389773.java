expect(mock.methodToTest(cmp(0))).andReturn(3);

public static <T> T cmp(int value) {
    reportMatcher(new IArgumentMatcher() {
        @Override
        public boolean matches(Object argument) {
            return value == ((A) argument).getValue();
        }

        @Override
        public void appendTo(StringBuffer buffer) {
            buffer.append("A.value=").append(value);
        }
    });
    return null;
}