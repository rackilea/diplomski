public class SemesterComparator implements Comparator<String> {

    private static final List<String> SEASONS = Arrays.asList("Spring", "Summer", "Fall", "Winter");

    @Override
    public int compare(String one, String two) {
        String[] partsOne = one.split(" ");
        String[] partsTwo = two.split(" ");
        if (partsOne.length != 2 || partsTwo.length != 2) {
            throw new IllegalArgumentException();
        }
        if (!SEASONS.contains(partsOne[0]) || !SEASONS.contains(partsTwo[0])) {
            throw new IllegalArgumentException();
        }

        // compare years
        int comparison = partsOne[1].compareTo(partsTwo[1]);
        if (comparison == 0) {
            // if years are equal: compare season
            comparison = SEASONS.indexOf(partsOne[0]).compareTo(SEASONS.indexOf(partsTwo[0]));
        }
        return comparison;
    }
}