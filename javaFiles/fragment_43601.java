public class PlayingArea {
    private String letters;
    private char[][] grid;

    public PlayingArea(String letters) {
        this.letters = letters;
    }

    public void populate() {
        int n = letters.length();
        grid = new char[12][12];

        Random r = new Random();
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid.length; i++) {
                grid[i][j] = letters.charAt(r.nextInt(n));
            }
        }

    }

    public String gridAsString() {
        StringBuilder sb = new StringBuilder();
        for (char[] letterRow : grid) {
            sb.append(Arrays.toString(letterRow)).append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many regions would you like (2- 4)");
        String letters = "";
        while (letters.length() < 2) {
            int region = input.nextInt();
            if (region == 4) {
                letters = "EFGH";
            } else if (region == 3) {
                letters = "EFG";
            } else if (region == 2) {
                letters = "EF";
            } else {
                System.out.println("You inputed a wrong value, try again...");
            }
        }
        PlayingArea playingArea = new PlayingArea(letters);
        playingArea.populate();
        System.out.println(playingArea.gridAsString());
    }
}