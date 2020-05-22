public class CachedIntegerAggregator {

    private List<Integer> integers;

    private boolean isSumCalculated = false;
    private int sum = 0;

    private boolean isMultiCalculated = false;
    private int multi = 0;

    public CachedIntegerAggregator(Integer... integers) {
        this(Arrays.asList(integers));
    }

    public CachedIntegerAggregator(Collection<Integer> integers) {
        this.integers = new ArrayList<Integer>(integers);
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public int getSum() {
        if (!isSumCalculated) {
            sum = 0;
            for (Integer integer: integers) {
                sum += integer;
            }
            isSumCalculated = true;
        }
        return sum;
    }

    public int getMulti() {
        if (!isMultiCalculated) {
            multi = 1;
            for (Integer integer: integers) {
                multi *= integer;
            }
            isMultiCalculated = true;
        }
        return multi;
    }

}