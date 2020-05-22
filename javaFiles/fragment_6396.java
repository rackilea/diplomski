public static List<Integer> getPrice(List<Integer> list) {
    SetUniqueList<Integer> result = new SetUniqueList<Integer>();
    for (Integer number : list) {
        int occurrences = Collections.frequency(list, number); 
        if (occurrences > 3) {
            result.add(number);
        }
    }
    return result;
}