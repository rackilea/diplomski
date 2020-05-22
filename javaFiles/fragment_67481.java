String name = JOptionPane.showInputDialog(null,"Enter your name:");
char[] chars = name.toCharArray();
System.out.print("your name is: ");
int sum = 0;
for (char c : chars) {
    sum += (int)c;
}
System.out.println(sum);