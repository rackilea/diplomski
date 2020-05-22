private String charOf(int x, int colIndex, int maxCols){
            Char char = '';
            switch(int){
                     case 1: 
                             char = 'A';
                             break;
                     case 2:
                             char = 'B';
                             break;
                     ....... etc
             }
          return (colIndex < maxCols-1 ? char+"\t" : char);
       }