public class ArrayReader {

    public static IntegerArray readIntArray(InputStream input) {
        Scanner scanner = new Scanner(input);
        List<Integer> intList = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            intList.add(scanner.nextInt());
        }
        scanner.close();

        return new IntegerArray(intList.stream().mapToInt(Integer::intValue).toArray());
    }

    public static void main(String args[]) throws Exception {
        FileInputStream fin = new FileInputStream("num.txt");
        IntegerArray integerArray = readIntArray(fin);
        System.out.println(integerArray.sum());
        System.out.println(integerArray.average());
        fin.close();
    }
}