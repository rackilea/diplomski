public class Solution {
    public int twoSum(int[] numbers, int k) {
        if (numbers == null) {
            return null;
        }
        int count = 0;
        HashMap<Integer, Integer> difference = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            difference.put(k - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int cur = -numbers[i];
            if (difference.containsKey(cur) && difference.get(cur) != i) {
                count++;
            }
        }
        return count;
    }
}