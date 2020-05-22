public static InputStream foo(List<byte[]> binary) {
    int size = binary.size();
    return new InputStream() {
        int i = 0, j = 0;
        @Override
        public int read() throws IOException {
            if (i >= size) return -1;
            if (j >= binary.get(i).length) {
                ++i;
                j = 0;
            }
            if (i >= size) return -1;
            return binary.get(i)[j++];
        }
    };
}