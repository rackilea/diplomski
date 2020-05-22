public class App {

    public static void main(String[] args) {
        Map<String, List<Integer>> treeMap = new TreeMap<>();
        treeMap.put("ABSTRACT CLASS", Arrays.asList(1, 2, 3, 4));
        treeMap.put("\u200eABSOLUTE PATHNAME", Arrays.asList(11, 22, 33, 44));

        for (Entry<String, List<Integer>> entry : treeMap.entrySet()) {
            System.out.println(entry);
        }
    }
}