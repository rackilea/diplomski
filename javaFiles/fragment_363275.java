try {
             String content[] = line.split(" ");
            if(content.length > 3) {
                 if(content[0].equals("#")) {
                   int side1 = Integer.valueOf(content[1]);
                   int side2 = Integer.valueOf(content[2]);
                   int side3 = Integer.valueOf(content[3]);
                   if(side1 > 0 && side2 > 0 && side3 > 0) {
                      areaCalc(side1, side2, side3, lineCounter, output);
                  }
               }
            }
       }catch(NumberFormatException e){}