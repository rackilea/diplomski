public class DoubleMatchingTest {
    static class Dependency {
        public double applyWithDouble(double value) { return 0; }
        public double applyWithDoubles(double... values) { return 0; }
        public double applyWithDoubleArray(Double[] values) { return 0; }
    }

    @Mocked Dependency mock;

    @Test
    public void matchDoubles() {
        new Expectations() {{
            // Match the expected double value within a given tolerance:
            mock.applyWithDouble(withEqual(4.5, 0.01));
            result = 4.0;

            // Argument matchers can be used on the values of a varargs parameter:
            mock.applyWithDoubles(withEqual(4.0, 0.1), withEqual(5.0, 0.1));
            result = 8.3;

            // Matchers cannot be used in arrays, so create/reuse a custom matcher:
            mock.applyWithDoubleArray(with(new DoubleArrayMatcher(0.1, 4.0, 5.0)));
            result = 7.5;
        }};

        assertEquals(4.0, mock.applyWithDouble(4.51), 0);
        assertEquals(8.3, mock.applyWithDoubles(4.1, 4.9), 0);
        assertEquals(7.5, mock.applyWithDoubleArray(new Double[] {4.1, 4.9}), 0);
    }

    // Reusable custom matcher.
    static final class DoubleArrayMatcher implements Delegate<Double[]> {
        private final double tolerance;
        private final Double[] expected;

        DoubleArrayMatcher(double tolerance, Double... expectedValues) {
            this.tolerance = tolerance;
            expected = expectedValues;
        }

        @SuppressWarnings("unused")
        boolean matches(Double[] actual) {
            if (actual == null || actual.length != expected.length) return false;

            for (int i = 0; i < actual.length; i++) {
                double diff = expected[i] - actual[i];
                if (Math.abs(diff) > tolerance) return false;
            }

            return true;
        }
    }
}