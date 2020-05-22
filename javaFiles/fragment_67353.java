public class Test {

    static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    static int[] groups = new int[] { 3, 4, 2, 3 };

    public static void main(String[] args) throws Exception {
        print("", 0, list);
    }

    private static void print(String previousVector, int groupIndex, List<Integer> aList) {
        if (groupIndex == groups.length) { // last group
            System.out.println(previousVector);
            return;
        }

        ICombinatoricsVector<Integer> vector = Factory.createVector(aList.toArray(new Integer[0]));
        Generator<Integer> generator = Factory.createSimpleCombinationGenerator(vector, groups[groupIndex]);

        for (ICombinatoricsVector<Integer> combination : generator) {
            String vectorString = previousVector + combination.getVector().toString();
            List<Integer> copy = new LinkedList<>(aList);
            copy.removeAll(combination.getVector());
            print(vectorString, groupIndex + 1, copy); 
        }
    }
}