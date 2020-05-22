if( col < 8 ) {
          if (solve(row, col + 1)) {
              return true;
          }
       } else {
          if (solve(row + 1, 0)) {
              return true;
          }
       }