public class Driver {
    public static void main(String[] args){
        String str = "Jack started the game form 9 pm to 11 pm, he got score 73.2";
        new Games().textParser(str);
    }
}

public class Games {

    public /* static */ void textParser(String str) {
        String[] parts = str.split("\\s+");

        List<String> words = getWords(parts);
        System.out.println("number of words " + words.size());
        System.out.println(words);

        List<Integer> num = getIntegerNumbers(parts);
        System.out.println("number of numbers " + num.size());
        System.out.println(num);


        List<Double> number = getDoubleNumbers(parts);
        System.out.println("number of doubles " + number.size());
        System.out.println(number);
    }

    private static List<String> getWords(String... parts) {
        return Arrays.stream(parts)
                     .filter(str -> {
                         try {
                             Double.parseDouble(str);
                             return false;
                         } catch(Exception e) {
                             return true;
                         }
                     })
                     .collect(Collectors.toList());
    }

    private static List<Integer> getIntegerNumbers(String... parts) {
        return Arrays.stream(parts)
                     .map(str -> {
                         try {
                             return Integer.parseInt(str);
                         } catch(Exception e) {
                             return null;
                         }
                     })
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    private static List<Double> getDoubleNumbers(String... parts) {
        return Arrays.stream(parts)
                     .map(str -> {
                         try {
                             return Double.parseDouble(str);
                         } catch(Exception e) {
                             return null;
                         }
                     })
                     .filter(Objects::nonNull)
                     .filter(val -> Double.compare(val, val.intValue()) != 0)
                     .collect(Collectors.toList());
    }
}