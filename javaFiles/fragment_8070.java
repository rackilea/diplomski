public class Practise {
    public static void main(String[] args) {   
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        int[] array = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 8 };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    result.put(i, array[i]);
                }
            }
        }
        System.out.println(result);
    }
}