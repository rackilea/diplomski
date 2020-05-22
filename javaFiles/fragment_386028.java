public static int[][] readASolution(String filename) {
        int[][] grid = new int[9][9];

        try {
            Scanner sc = new Scanner(new File(filename));
            int i = 0;

            while(sc.hasNext()) {
                int j = 0;
                String line = sc.nextLine();

                for( int x = 0; x < line.length(); x++) 
                    if( Character.isDigit(line.charAt(x)) ) {
                        grid[i][j] = Character.getNumericValue(line.charAt(x)); 
                        j++;
                    }
                if (i == 9) break;
                i++; 
            }
        } catch(FileNotFoundException e ) { 
            System.err.println( "Error: " + e );
        }
        return grid;
    }