public class IntegerSubstringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        Integer leftInt = Integer.parseInt(left.substring(left.indexOf("^") + 1));
        Integer rightInt = Integer.parseInt(right.substring(right.indexOf("^") + 1));

        return -1 * leftInt.compareTo(rightInt);
    }
}