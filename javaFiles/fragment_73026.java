Collections.sort(matchedWords, new Comparator<String>() {
        @Override
        public int compare(String lhs, String rhs) {

            return lhs.compareToIgnoreCase(rhs);
        }
    });