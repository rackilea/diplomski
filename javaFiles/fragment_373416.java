public class Testing {

    private static class MyNumber {
        private final int id;
        private final int number;

        public MyNumber(int id, int number) {
            this.id = id;
            this.number = number;
        }

        public int getId() {
            return id;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void main(String[] args) {
        int[][] arrayToSort = {
                {0, 1,    2,  3,  4,  5,   6,  7  },
                {0, 1065, 70, 60, 90, 251, 24, 558}
        };

        List<MyNumber> list = IntStream.range(0, arrayToSort[0].length)
                .mapToObj(i -> new MyNumber(arrayToSort[0][i], arrayToSort[1][i]))
                .collect(toList());

        Collections.sort(list, Comparator.comparing(MyNumber::getNumber));

        for (MyNumber myNumber : list) {
            System.out.println(myNumber.getId() + " " + myNumber.getNumber());
        }
    }
}