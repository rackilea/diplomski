public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("myfile.txt");
        String[] lines = Files.readAllLines(file.toPath()).toArray(new String[0]);
        lines = Arrays.stream(lines).map(l -> l.replaceAll("^.{11}(\\d).*$", "$1")).toArray(String[]::new);

        long n1 = Arrays.stream(lines).filter(s -> s.equals("1")).count();
        long n2 = Arrays.stream(lines).filter(s -> s.equals("2")).count();
        long n3 = Arrays.stream(lines).filter(s -> s.equals("3")).count();
        long n4 = Arrays.stream(lines).filter(s -> s.equals("4")).count();

        System.out.println("n1 = " + n1 + ", n2 = " + n2 + ", n3 = " + n3 + ", n4 = " + n4);
    }

}