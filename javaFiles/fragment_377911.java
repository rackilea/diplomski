public final int add_t() {
    boolean canceled = false;
    for (int index = 0; index < ColorType.length; index++) {

        Integer value = promptForInt("Please enter your t order for " + ColorType[index]);
        if (value != null) {
            Color[index] = value;
        } else {
            canceled = true;
            break;
        }
    }
    if (!canceled) {
        sum = Color[0] + Color[1] + Color[2];
        JOptionPane.showMessageDialog(null, "Your total order is " + sum);
    }
    return canceled ? -1 : Color.length;
}