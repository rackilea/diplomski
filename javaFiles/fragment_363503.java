import java.util.*;

public class PermuteBySorting {
    public static void main(String[] args) {
        class PrioritizedValue<T> implements Comparable<PrioritizedValue<T>> {
            final T value;
            final int priority;
            PrioritizedValue(T value, int priority) {
                this.value = value;
                this.priority = priority;
            }
            @Override public int compareTo(PrioritizedValue other) {
                return Integer.valueOf(this.priority).compareTo(other.priority);
            }           
        }
        int[] nums = { 1, 2, 3, 4 };
        int[] priorities = { 36, 3, 97, 19 };
        final int N = nums.length;
        List<PrioritizedValue<Integer>> list =
            new ArrayList<PrioritizedValue<Integer>>(N);
        for (int i = 0; i < N; i++) {
            list.add(new PrioritizedValue<Integer>(nums[i], priorities[i]));
        }
        Collections.sort(list);
        int[] permuted = new int[N];
        for (int i = 0; i < N; i++) {
            permuted[i] = list.get(i).value;
        }
        System.out.println(Arrays.toString(permuted));
        // prints "[2, 4, 1, 3]"
    }
}