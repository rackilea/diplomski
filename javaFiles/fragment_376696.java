public static Comparator<String> createCaselessStringCompatator() {
    return new Comparator<String> () {
        public int compare(String o1, String o2) {
            return o1.toUpperCase().compareTo(o2.toUpperCase());
        }
    }; 
}

public static Comparator<String> createNumericStringCompatator() {
    return new Comparator<String> () {
        public int compare(String o1, String o2) {
            return new Double(o1).compareTo(new Double(o2));
        }
    }; 
}