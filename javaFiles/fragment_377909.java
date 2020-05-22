public final int add_t() {
    for (int index = 0; index < ColorType.length; index++) {
        boolean test = true;
        while (test == true) {
            try {
                String orderItems = JOptionPane.showInputDialog("Please enter your t order for " + ColorType[index]);
                int items = Integer.parseInt(orderItems);
                Color[index] = items;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Input must be a number.");
            }
        }
    }
    sum = Color[0] + Color[1] + Color[2];
    JOptionPane.showMessageDialog(null, "Your total order is " + sum);
    return Color.length;
}