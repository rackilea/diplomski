public void checkVertical() {

        for (int i = 1; i < (word.length()); i++) {

            if (rowLocation + i > letterGrid.length - 1 || colLocation + i > letterGrid[0].length) {

                return;

            } else if (letterGrid[rowLocation + i][colLocation] != word.charAt(i)) {

                return;

            }//end of if..else if

        }//end of for loop

        System.out.println(word + " found vertically at row " + rowLocation + " and column " + colLocation); // Word found!!
        System.out.println();

    }//end of checkVertical()