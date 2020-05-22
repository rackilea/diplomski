Arrays.sort(inputArr, new Comparator<String>() {
    @Override
    public int compare(String entry1, String entry2) {
        String[] entry1Split = entry1.split("::");
        String[] entry2Split = entry2.split("::");

        return Double.valueOf(entry1Split[2]).compareTo(Double.valueOf(entry2Split[2]));
    }
});