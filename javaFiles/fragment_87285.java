public class NewClass5 {
    public static void main(String[] args) {
        String[][] matrix = {{"mark","smith","34"},
                             {"simon","black","24"},
                             {"foo","bar","44"}
                            }; 

        Arrays.sort(matrix, new CompareByColumn(1));// pass the desired index
        for(String[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
    }
    static class CompareByColumn implements Comparator {
        int columnToSort;
        CompareByColumn(int columnToSort) {
            this.columnToSort = columnToSort;
        }
        public int compare(Object o1, Object o2) {
                String[] row1 = (String[]) o1;
                String[] row2 = (String[]) o2;
                return row1[columnToSort].compareTo(row2[columnToSort]);
        }
    }    
}