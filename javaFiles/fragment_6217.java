Collections.sort(entries, new Comparator<String>() {
    @Override
    public int compare(String left, String right) {
        String[] leftFragments = left.split("[|]");
        String[] rightFragments = right.split("[|]");
        if(leftFragments[0].compareTo(rightFragments[0]) == 0) {
            return leftFragments[1].compareTo(rightFragments[1]);
        } else {
            return leftFragments[0].compareTo(rightFragments[0]);
        }
    }
});