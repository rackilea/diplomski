public class Test {

public static void main(String[] args) {

    List<String> result = new ArrayList<>();

    Set<Character> set = new HashSet<>();
    for (int i = 1234; i <= 9876; i++) {
        set.clear();

        String iAsString = Integer.toString(i);
        char[] chars = iAsString.toCharArray();

        boolean valid = true;
        for (char c : chars) {
            if (c == '0' || !set.add(c)) {
                valid = false;
                break;
            }
        }

        if (valid) {
            result.add(iAsString);
        }
    }


    String[] yourStringArray = result.toArray(new String[result.size()]);

    System.out.println(Arrays.toString(yourStringArray));

}


}