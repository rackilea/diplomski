import java.util.*;

public class Playground1 {
    public static void main(String[] args) {

        // fake resultset
        List<DBResultSetRowEmulation> resultSetEmulation = new ArrayList<>();
        resultSetEmulation.add(new DBResultSetRowEmulation(1, 2, "one"));
        resultSetEmulation.add(new DBResultSetRowEmulation(1, 2, "two"));
        resultSetEmulation.add(new DBResultSetRowEmulation(1, 3, "three"));
        resultSetEmulation.add(new DBResultSetRowEmulation(5, 3, "four"));
        resultSetEmulation.add(new DBResultSetRowEmulation(5, 2, "five"));
        resultSetEmulation.add(new DBResultSetRowEmulation(5, 3, "six"));

        Map<DoubleIndex, List<String>> resultData = new HashMap<>();

        // iterate through resultset
        for(DBResultSetRowEmulation row: resultSetEmulation) {
            DoubleIndex curRecordIdx = new DoubleIndex(row.a, row.b);
            if (resultData.containsKey(curRecordIdx)) {
                // append current string to some existing id1+id2 combination
                resultData.get(curRecordIdx).add(row.c);
            } else {
                // create a new list for new id1+id2 combination
                resultData.put(curRecordIdx, new ArrayList<>(Collections.singletonList(row.c)));
            }
        }

        System.out.println(resultData);
    }

    private static class DBResultSetRowEmulation {
        Integer a, b;
        String c;

        DBResultSetRowEmulation(Integer a, Integer b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static class DoubleIndex {
        private Integer a,b;

        public DoubleIndex(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DoubleIndex that = (DoubleIndex) o;

            return a.equals(that.a) && b.equals(that.b);
        }

        @Override
        public int hashCode() {
            int result = a.hashCode();
            result = 31 * result + b.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "id{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}