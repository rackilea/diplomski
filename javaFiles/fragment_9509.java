public class Anagram {

    public static void main(String[] args) {
        String[] listAnagrams = new String[]{"asp", "pas", "code", "coed", "deco", "France"};

        Optional<Map.Entry<String, List<String>>> maxNormalised = Arrays.stream(listAnagrams)
                .collect(Collectors.groupingBy(Anagram::normalize))
                .entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()));

        System.out.print("Most occurring anagrams are: " + maxNormalised.get().getValue());
    }

    private static String normalize(String inputString){
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}