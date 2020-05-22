public class ACSLPrintsJR {
    public static int value(int num) {
        int[] array = {0, 16, 16, 8, 8, 4, 4, 2, 2, 1, 1};
        return array[num];
    }

    public static void main(String[] args) throws IOException {
        File file = new File("ACSLPRINTSJR.IN");
        Scanner scan = new Scanner(file);
        int num;
        while (scan.hasNext()) {
            int top = 1;
            int bottom = 1;
            while ((num = scan.nextInt()) != 0) {
                if (num % 2 == 0)
                    top += value(num);
                else
                    bottom += value(num);
            }
            System.out.println(top + "/" + bottom);
        }
        scan.close();
    }
}