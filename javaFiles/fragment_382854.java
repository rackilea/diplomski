public class random2DChar {
    public static void main(String args[]) {
        char[][] char2DArr = new char[10][10];
        Random random = new Random();
        int x = random.nextInt(char2DArr.length);
        char2DArr[x][x] = 'M';
        System.out.println(Arrays.deepToString(char2DArr));
    }
}