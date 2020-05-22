public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        compoundShuffle(list, 8, 13);
        compoundUnshuffle(list, 8, 13);
        System.out.println(list);
    }

    public static void compoundShuffle(List<?> list, int repetition, long seed) {
        Random rand = new Random(seed);
        for (int i = 0; i < repetition; i++)
            Collections.shuffle(list, rand);
    }

    public static void compoundUnshuffle(List<?> list, int repetition, long seed) {
        helper(list, repetition, seed);
    }

    private static <E> void helper(List<E> list, int repetition, long seed) {
        List<Integer> indices = new ArrayList<Integer>();
        int size = list.size();
        for (int i = 0; i < size; i++)
            indices.add(i);
        compoundShuffle(indices, repetition, seed);
        List<E> copy = new ArrayList<E>(list);
        for (int i = 0; i < size; i++)
            list.set(indices.get(i), copy.get(i));
    }
}