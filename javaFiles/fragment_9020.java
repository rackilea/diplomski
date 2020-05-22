import java.io.*;

class cptest {
    public static void main(String[] args) {
        try (BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
            br.lines().flatMapToInt(String::codePoints).forEach(cptest::print);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
    private static void print(int cp) {
        String s = new String(Character.toChars(cp));
        System.out.println("Character " + cp + ": " + s);
    }
}