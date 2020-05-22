public class RatingService {

    public int calculate(List<Integer> input) {
        return recursion(input, true, 0);
    }

    private int recursion(List<Integer> sublist, boolean canSkip, int sum) {
        if (sublist.isEmpty()) {
            return sum;
        }
        int skippedSum = Integer.MIN_VALUE;
        int notSkippedSum;
        Integer integer = sublist.get(0);

        if (canSkip) {
            skippedSum = recursion(sublist.subList(1, sublist.size()), false, sum);
        }
        notSkippedSum = recursion(sublist.subList(1, sublist.size()), true, integer + sum);

        return skippedSum > notSkippedSum ? skippedSum : notSkippedSum;
    }
    }