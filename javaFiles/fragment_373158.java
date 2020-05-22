List<String> asList = stringStream.collect(
    new Supplier<ArrayList<String>>() {
        @Override
        public ArrayList<String> get() {
            return new ArrayList<>();
        }
    },

    new BiConsumer<ArrayList<String>,String>() {
        @Override
        public void accept(ArrayList<String> list, String item) {
            list.add(item);
        }
    },

    new BiConsumer<ArrayList<String>,ArrayList<String>>() {
        @Override
        public void accept(ArrayList<String> list1, ArrayList<String> list2) {
            list1.addAll(list2);
        }
    }
);