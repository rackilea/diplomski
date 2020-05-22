public static void main(String args[]){
    String num1 = JOptionPane.showInputDialog(null,"Enter a number");
    String num2 = JOptionPane.showInputDialog(null,"Enter another number");

    int ans = Integer.parseInt(num1);
    ans += Integer.parseInt(num2);

    JOptionPane.showMessageDialog(null,"Your answer is " + ans);
}