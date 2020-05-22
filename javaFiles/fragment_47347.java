public class MutableTest extends Test {
        private int mutable;
        public MutableTest(String url) {
                super(url);
        }

        @Override
        public String getUrl() {
                return super.getUrl() + mutable++;
        }
}