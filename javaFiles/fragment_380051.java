Comparator<SearchResult> comparator = 
    new Comparator<SearchResult>() {
        @Override
        public int compare(SearchResult sr1, SearchResult sr2) {
            // Optional support for null arguments is left as
            // an exercise for the reader.
            return Integer.compare(sr1.getNumber(), sr2.getNumber());
        }
    };