public final class Templates {
    public enum NewDeviceDetailsConsts {
        AAA("aaaa"), BBB("bbbb"), CCC("cccc");

        private String value;

        private NewDeviceDetailsConsts(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}