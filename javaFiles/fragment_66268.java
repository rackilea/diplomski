public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = input.readLine()) != null) {
                if ("".equals(line)) break;
                sb.append(line).append('\n');
            }
            System.out.println(Arrays.toString(sb.toString().split("\n")));
        }
    }
}