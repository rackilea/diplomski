public static void main(String[] args) {
    // should remove 3, 6-11, 18-20
    System.out.println(remove(Arrays.asList("3", "11", "20"),
                              new ArrayList<>(Arrays.asList("1", "2", "3", "6-11", "18-20"))));
    // should remove 2, not remove 6-11 (not a range), and not remove 18-20 (8 is not 18, 2 is not 20)
    System.out.println(remove(Arrays.asList("2", "8"),
                              new ArrayList<>(Arrays.asList("1", "2", "3", "6-11", "18-20"))));
}
private static List<String> remove(List<String> listOne, List<String> listTwo) {
    for (Iterator<String> listIter = listTwo.iterator(); listIter.hasNext(); ) {
        String value = listIter.next();
        if (shouldRemove(value, listOne))
            listIter.remove();
    }
    return listTwo; // for easy of use
}
private static boolean shouldRemove(String value, List<String> listOne) {
    int idx = value.indexOf('-');
    if (idx == -1) {
        for (String ref : listOne)
            if (ref.equals(value))
                return true;
    } else {
        String value1 = value.substring(0, idx);
        String value2 = value.substring(idx + 1);
        for (String ref : listOne)
            if (ref.equals(value1) || ref.equals(value2))
                return true;
    }
    return false;
}