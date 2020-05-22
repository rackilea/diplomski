public static void main(String[] args) {
    String str = "astv*12atthh124ggh*dhr1234sfff123*dgdfg1234*mnaoj";
    List<String> strings = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    Pattern digitPattern = Pattern.compile("\\d+");
    Pattern alphaPattern = Pattern.compile("[a-z]+");
    String[] splittedArray = str.split("\\*");
    for (String nextSplittedString : splittedArray) {
        Matcher digitMatcher = digitPattern.matcher(nextSplittedString);
        Matcher alphaMatcher = alphaPattern.matcher(nextSplittedString);
        String nextDigitAsString = "";
        while (digitMatcher.find()) {
            nextDigitAsString += digitMatcher.group();
        }
        if (!nextDigitAsString.isEmpty()) {
            nums.add(Integer.parseInt(nextDigitAsString));
        }

        String nextString = "";
        while (alphaMatcher.find()) {
            nextString += alphaMatcher.group();
        }
        if (!nextString.isEmpty()) {
            strings.add(nextString);
        }
     }
     System.out.println(nums);
     System.out.println(strings);
}