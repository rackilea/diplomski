class c4check {
    public static void main(String[] args) {
        char grid[][] = {{'e','e','e','e','a','b','a'},
                         {'e','a','b','a','b','b','a'},
                         {'e','b','a','a','b','b','a'},
                         {'e','a','b','b','a','b','b'},
                         {'e','b','a','b','b','a','a'},
                         {'e','a','b','a','b','b','a'}};
        int ii, jj, ri, ci, di;
        String checkGrid[] = new String[25];

        // copy rows:
        for(ri = 0; ri < 6; ri++) {
          String temp = "";
          for(ci = 0; ci < 7; ci++) {
            temp += grid[ri][ci];
          }
          checkGrid[ri] = temp;
        }
        // copy columns:
        for(ci = 0; ci < 7; ci++) {
          String temp = "";
          for(ri = 0; ri < 6; ri++) {
            temp += grid[ri][ci];
          }
          checkGrid[ci + 6] = temp;
        }
        // copy first diagonals:
        for(di = 0; di < 6; di++) {
          String temp = "";
          for(ri = 0; ri < 6; ri++) {
            ci = di - 2;
            ri = 0;
            while(ci < 0) {
              ri++;
              ci++;
            }
            for(; ri < 6; ri++, ci++) {
              if( ci > 6 ) continue;
              temp += grid[ri][ci];
            }
          }
          checkGrid[di+13] = temp;
        }
        // diagonals in the other direction:
        for(di = 0; di < 6; di++) {
          String temp = "";
          for(ri = 0; ri < 6; ri++) {
            ci = 8 - di;
            ri = 0;
            while(ci >  6) {
              ri++;
              ci--;
            }
            for(; ri < 6; ri++, ci--) {
              if( ci < 0 ) continue;
              temp += grid[ri][ci];
            }
          }
          checkGrid[di+19] = temp;
        }
        for(ii = 0; ii < 25; ii++) {
          System.out.println("Checking '" + checkGrid[ii] + "'");
          if (checkGrid[ii].contains("aaaa")) System.out.println("Player A wins!");
          if (checkGrid[ii].contains("bbbb")) System.out.println("Player B wins!");
        }
    }
}