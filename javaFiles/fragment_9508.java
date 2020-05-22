public class Anagram {

    public static void main(String[] args) {
        String[] listAnagrams = new String[]{"asp", "pas", "code", "coed", "deco", "France"};
        Map<String, List<String>> countMap = new HashMap<>();
        for (String str : listAnagrams) {
            String normalized = normalize(str);
            List<String> strings = countMap.getOrDefault(normalized, new ArrayList<>());
            strings.add(str);
            countMap.put(normalized, strings);
        }
        Optional<Map.Entry<String, List<String>>> max = countMap.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()));

        System.out.print("Most occurring anagrams are: " + max.get().getValue());
    }

    private static String normalize(String inputString){
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}