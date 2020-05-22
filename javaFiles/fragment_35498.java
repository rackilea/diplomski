private static Mapper<Sequence<String>, String> readFromConsole() {
    return new Mapper<Sequence<String>, String>() {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public String call(Sequence<String> lines) throws Exception {
            return reader.readLine();
        }
    };
}