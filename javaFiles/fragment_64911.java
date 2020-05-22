public class StringPartsComparator implements Comparator<String> {

    @Override
    public int compare (String s1, String s2) {
        String[] arr1 = s1.split("-");
        int len1 = arr1.length;

        String[] arr2 = s2.split("-");
        int len2 = arr2.length;

        int commonLength = Math.min(len1, len2);

        // Go over the "common" elements.
        // Return if any element differs from its counterpart
        for (int i = 0; i < commonLength; ++i) {
            int int1 = Integer.parseInt(arr1[i]);
            int int2 = Integer.parseInt(arr2[i]);
            int comp = Integer.compare(int1, int2);
            if (comp != 0) {
                return comp;
            }
        }

        // All the common elements are equal,
        // the longer string should be considered "bigger"
        return Integer.compare(len1, len2);
    }
}