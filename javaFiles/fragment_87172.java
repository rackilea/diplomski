Comparator<String> stringAndNumberComparator = (s1, s2) -> {
    try {
        return Double.valueOf(s1).compareTo(Double.valueOf(s2));
    } catch (NumberFormatException e) {
        return s1.compareTo(s2);
    }
};