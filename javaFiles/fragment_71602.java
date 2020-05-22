public static void main(String[] args)
{
    final int data[] = new int[] {24, 26, 28, 29, 30, 32, 32, 35, 37, 38, 38, 40, 41, 42, 43, 44, 44, 45, 45, 46, 47, 47, 47, 48, 48, 48, 48, 49, 49, 50, 50, 50, 51, 52, 52, 53, 53, 53, 53, 53, 54, 54, 56, 56, 56, 57, 57, 57, 57, 58, 58, 58, 59, 60, 60, 60, 60, 61, 61, 61, 61, 62, 62, 62, 62, 62, 63, 64, 64, 64, 65, 65, 65, 66, 66, 66, 67, 67, 67, 67, 67, 68, 70, 71, 71, 72, 72, 72, 73, 73, 73, 75, 76, 76, 76, 76, 77, 77, 77, 77, 77, 78, 78, 78, 78, 78, 80, 80, 80, 81, 82, 83, 84, 85, 85, 85, 85, 85, 88, 89, 91, 91, 93, 96, 97};
    final int MAX = 100;

    final int[] counts = new int[MAX];

    for (int i = 0; i < data.length; ++i) {
        int num = data[i];
        counts[num]++;
    }

    OptionalInt oi = Arrays.stream(counts).max();
    int cnt = oi.getAsInt();

    System.out.println("Modes for input data");
    for (int i = 0; i < counts.length; ++i) {
        if (counts[i] == cnt) {
            System.out.print(String.format("%3d", i));
        }
    }
    System.out.println();
   }