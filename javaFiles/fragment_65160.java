public static void main(String[] args) {
    String L;
    int lenght;
    L = JOptionPane.showInputDialog(null, "enter lenght: ");
    lenght = Integer.parseInt(L);

    int[] num = new int[lenght];
    int max=0;
    for (int counter = 0; counter < lenght; counter++) {

        JOptionPane.showInputDialog(null, "enter #: " + (counter + 0));
        max = num[0];

        if (num[counter] > max) {

            max = num[counter];
        }

    }

    JOptionPane.showMessageDialog(null, "the largest number is: " + max);
}