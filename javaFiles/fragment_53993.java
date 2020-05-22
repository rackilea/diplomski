public class ClothesSizeComparator implements Comparator<String> {
    private static final List<String> SIZES = 
        Arrays.asList("XS", "S", "M", "L", "XL", "XXL", "3XL");

    @Override
    public int compare(String s1, String s2) {
        int s1pos = SIZES.indexOf(s1);
        int s2pos = SIZES.indexOf(s2);
        return Integer.compare(s1pos, s2pos);
    }
}