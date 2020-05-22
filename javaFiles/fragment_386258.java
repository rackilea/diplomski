public static void main(String[] args) {
    String[][] start = {{"d", "d", "+", "+"}, {"a", "d", "d", "+"}, {"a", "b", "b", "c"}, {"", "a", "_", "d"}};
    for (int i = 0; i < start.length; i++) {
        for (int j = 0; j < start[i].length; j++) {
            System.out.print(start[i][j] + " ");
            //here you should to check if your index is > 0 
            if (j > 0) {
                //here you make your swapping if your attribute = to _ 
                //and the previews value is not equal to + like you said in your question
                if (start[i][j].equals("_") && !start[i][j-1].equals("+")) {
                    String x = start[i][j - 1];
                    start[i][j - 1] = "_";
                    start[i][j] = x;
                }
            }

        }
        System.out.println();
    }

    //print your result
    for (int i = 0; i < start.length; i++) {
        for (int j = 0; j < start[i].length; j++) {
            System.out.print(start[i][j] + " ");
        }
        System.out.println();
    }
}