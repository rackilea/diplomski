public static void main(String[] args) {

        Object[][] field = new Object[10][10];

        for (int i = 0; i < field.length; i++) {
            System.out.println("Total Rows: " + field.length);
            for(int j = 0; j < field[i].length; j++){
               System.out.println("Row: " + i);
               System.out.println("Length: " + field[i].length);
            }
        }

        System.out.println("Goodbye.");
    }