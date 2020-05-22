int[] num = new int[4];
num[0] = Integer.parseInt(JOptionPane.showInputDialog("Write a number."));
num[1] = Integer.parseInt(JOptionPane.showInputDialog("Write a number."));
num[2] = Integer.parseInt(JOptionPane.showInputDialog("Write a number."));
num[3] = Integer.parseInt(JOptionPane.showInputDialog("Write a number."));

for (int i = 0; i < num.length; i++) {
   if (num[i] < 0) {
      System.out.println("Number " + num[i] + " is negative.");
      break;
   }
   if (num[i] > 0) {
      System.out.println(num[i] + " is a integer.");
   }
   if (num[i] == 0) {
      System.out.println(num[i] + " is zero.");
   }
}