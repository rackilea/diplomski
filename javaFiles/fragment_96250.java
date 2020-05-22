x = tfCells[rowSelected][colSelected].getText(); //get input
try {
    y = Integer.parseInt(x);
    System.out.println(y);
    if(y==puzzle[rowSelected][colSelected]) {
         tfCells[rowSelected][colSelected].setBackground(Color.green);
    } else {
         tfCells[rowSelected][colSelected].setBackground(Color.red);
    }
    if(masks[rowSelected][colSelected]) { //if all answers are correct
         long endtime = System.currentTimeMillis();
         long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(endtime - starttime); // time in seconds
         JOptionPane.showMessageDialog(null, "Finished in: " + timeSeconds);
    }
} catch (NumberFormatException exc){
    tfCells[rowSelected][colSelected].setBackground(Color.red);
}