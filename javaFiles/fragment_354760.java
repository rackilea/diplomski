public class Main {

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            try {
                numbers.add(Integer.parseInt(args[i]));
            } catch (NumberFormatException e) {
                colors.add(args[i]);
            }
        }

        String[] colorsArray = colors.toArray(new String[0]);
        int[] number = numbers.stream().mapToInt(num -> num).toArray();
    }
}