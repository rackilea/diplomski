public static void main(String[] args) {
  int maxRows = 3;
  paths(maxRows, 1, 1, "1");
}

/**
 * Recursive top to bottom depth first approach
 * 
 * @param maxRow Total number of rows to travel down.
 * @param rowNum The current row an iteration is on.
 * @param position The position number above the current iteration.
 * @param values The values so far along the path.
 */
public static void paths(int maxRow, int rowNum, int position, String values) {
  //You've hit the bottom so print the results
  if(rowNum >= maxRow) {
    System.out.println(values);
    return;
  }

  int nextRow = rowNum + 1;

  //Calculate position for left side branch, append it to values, and start next iteration
  int leftPosition = position + rowNum;
  String leftValues = values + " " + leftPosition;
  paths(maxRow, nextRow, leftPosition, leftValues);

  //Calculate position for right side branch, append it to values, and start next iteration
  int rightPosition = position + rowNum + 1;
  String rightValues = values + " " + rightPosition;
  paths(maxRow, nextRow, rightPosition, rightValues);
}