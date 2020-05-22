public static void main(String[] args) {
    String[][] matrix = {{"mark","smith","34"},
                         {"simon","black","24"},
                         {"foo","bar","44"}
                        };        

    Comparator<String[]> firstNameComparator  = new Comparator<String[]>() {
        @Override
        public int compare(String[] row1, String[] row2) {
            return row1[0].compareTo(row2[0]);
        }
    };
    Comparator<String[]> lastNameComparator  = new Comparator<String[]>() {
        @Override
        public int compare(String[] row1, String[] row2) {
            return row1[1].compareTo(row2[1]);
        }
    };
    Comparator<String[]> ageComparator  = new Comparator<String[]>() {
        @Override
        public int compare(String[] row1, String[] row2) {
            return Integer.compare(Integer.parseInt(row1[2]), Integer.parseInt(row2[2]));
        }
    };
    Arrays.sort(matrix, firstNameComparator);// pass the desired comparator
    for(String[] row:matrix){
        System.out.println(Arrays.toString(row));
    }
}