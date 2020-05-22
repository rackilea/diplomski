Collections.sort(recordList, new Comparator<Record>() {
        public int compare(Record object1, Record object2) {
            return Double.compare(object1.simiADD, object2.simiADD);
        }
    }
);