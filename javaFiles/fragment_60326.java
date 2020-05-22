public static void main(String[] args) throws FileNotFoundException {
    @SuppressWarnings("resource")
    File file = new File(args [0]);
    Scanner scanner = new Scanner(file).useDelimiter(",");

    try {
        ArrayList<Integer> Ray = new ArrayList<>();

        while (scanner.hasNext()) {
            String num = scanner.next().trim();
            Ray.add(Integer.parseInt(num));
        }

        scanner.close();
        int[] arr = Ray.stream().mapToInt(i -> i).toArray();
        Find(arr, 0, arr.length - 1);
    } catch (NumberFormatException ex) {

    }
}