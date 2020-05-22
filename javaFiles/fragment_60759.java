public enum FileType {
    TYPE_1 {
        public SimpleFileReader getFileReader() {
            return new Type1SimpleFileReader();
        }
    },

    TYPE_2 {
        public SimpleFileReader getFileReader() {
            return new Type2SimpleFileReader();
        }
    };

    public abstract SimpleFileReader getFileReader();
}