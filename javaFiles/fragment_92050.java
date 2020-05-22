public class BruteDiv3
{
    public static int maxDiv3(int[] arr)
    {
        return generateSubsets(arr, new BitSet(), 0, 0);
    }

    static int generateSubsets(int[] digits, BitSet selected, int pos, int maxDiv3)
    {
        if (pos == digits.length)
        {
            List<Integer> subset = toSubset(digits, selected);
            if (!subset.isEmpty())
            {
                maxDiv3 = permuteSubset(subset, 0, maxDiv3);
            }
            return maxDiv3;
        }

        boolean duplicate = false;
        for (int i = pos - 1; i >= 0; i--)
        {
            if (digits[i] == digits[pos] && !selected.get(i))
            {
                duplicate = true;
                break;
            }
        }

        if (!duplicate)
        {
            selected.set(pos);
            maxDiv3 = generateSubsets(digits, selected, pos + 1, maxDiv3);
            selected.clear(pos);
        }

        maxDiv3 = generateSubsets(digits, selected, pos + 1, maxDiv3);

        return maxDiv3;
    }

    static int permuteSubset(List<Integer> subset, int pos, int maxDiv3)
    {
        if (pos == subset.size())
        {
            int num = toInteger(subset);
            if (num % 3 == 0 && num > maxDiv3)
            {
                maxDiv3 = num;
            }
            return maxDiv3;
        }

        maxDiv3 = permuteSubset(subset, pos + 1, maxDiv3);

        for (int i = pos + 1; i < subset.size(); i++)
        {
            if (!subset.get(pos).equals(subset.get(i)))
            {
                List<Integer> permSubset = new ArrayList<>(subset);
                Collections.swap(permSubset, pos, i);
                maxDiv3 = permuteSubset(permSubset, pos + 1, maxDiv3);
            }
        }

        return maxDiv3;
    }

    static List<Integer> toSubset(int[] arr, BitSet on)
    {
        List<Integer> ss = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (on.get(i))
                ss.add(arr[i]);
        }
        return ss;
    }

    static int toInteger(List<Integer> digits)
    {
        int num = 0;
        for (int pow10 = 1, i = digits.size() - 1; i >= 0; i--, pow10 *= 10)
        {
            num += digits.get(i) * pow10;
        }
        return num;
    }
}