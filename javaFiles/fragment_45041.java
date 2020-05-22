public class Test {

    public static void main(String[] args) throws IOException {
        String fileName = "d:\\saveGame.txt";
        Scanner kb = new Scanner(new File(fileName));
        String gameSave = "GameSave";
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String in = input.readLine();
        String[] temp;
        int[] array = new int[0];
        if (in.contains(gameSave)) {
            temp = in.split(" ");
            array = new int[temp.length - 1];
            int j = 0;
            for (int i = 1 ; i < temp.length ; i++) {
                array[j] = Integer.parseInt(temp[i]);
                j++;
            }
        }

        for (int i = 0 ; i < array.length ; i++) {
            System.out.print("\n" + array[i]);
        }
    }
}