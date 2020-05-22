public class Answer1 {

    static final String input =
            "########\n" +
            "#   # .#\n" +
            "#   $$.#\n" +
            "####   #\n" +
            "   #@ ##\n" +
            "   ####";


    public static void main(String[] args) {

        List<List<String>> grid = new ArrayList<>();
        for(String line: input.split("\n")){
            List<String> row = new ArrayList<>();
            row.add(line);
            grid.add(row);
        }

        //test
        System.out.println(grid);

    }
}