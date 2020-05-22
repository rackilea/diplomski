public static void main(String[] args) {

  int start;
  int end;
  int result;

  start = Integer.parseInt(JOptionPane.showInputDialog(
      "Please enter a starting integer "));
  end = Integer.parseInt(JOptionPane.showInputDialog(
      "Please enter an ending integer "));

  String msg = "";
  while (start <= end) {
    msg = msg + " " + start;
    start++;
  }

  JOptionPane.showMessageDialog(null, msg);
}