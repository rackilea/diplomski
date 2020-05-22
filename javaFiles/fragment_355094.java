public class SandBox7 {
public static void main(String[] args) {
    Integer[] array = new Integer[] { 1, 4, 9 };
    SandBox7 s = new SandBox7();
    List<Integer> mis = s.getMissingNumbers(array);
}

public List<Integer> getMissingNumbers(Integer[] in) {
    int max = getMaximum(in);
    // System.out.println(max);
    List<Integer> numbers = Arrays.asList(in);

    ArrayList<Integer> missing = new ArrayList<>();
    for (int i = 1; i < max; i++) {

        if (!numbers.contains(i)) {
            missing.add(i);
        }
    }
    return missing;
}

private int getMaximum(Integer[] in) {
    int tmp = -1;
    for (int i = 0; i < in.length; i++) {
        if (tmp < in[i])
            tmp = in[i];
    }
    return tmp;
}

}