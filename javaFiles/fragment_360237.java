JButton btnCompute = new JButton("Compute");
public void handleAction() {
    btnCompute.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {

                int n1 = 5;
                int n2 = 4;
                int minValue = minFunction(n1, n2);

            }

            catch (NumberFormatException ex) {

            }
        }
    });
}
public int minFunction(int n1, int n2) {
    int min;
    if (n1 > n2)
        min = n2;
    else min = n1;

    return min;
}