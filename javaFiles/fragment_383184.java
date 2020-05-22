String[][] seats = new String[5][3];

for(int r = 0; r < seats.length; r++){
        System.out.printf(r+ "." );

        for (int c = 0; c < seats[r].length; c++){
            System.out.print("  0");
        }

        System.out.println("");
    }