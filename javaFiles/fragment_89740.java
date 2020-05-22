for (String s : new Iterable<String>() {
        @Override
        public Iterator<String> iterator() {
            return stream.iterator();
        }
    }) {
        writer.append(s);
    }