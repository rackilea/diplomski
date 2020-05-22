public class YourClass {
    public void foo() {
        JButton b = new JButton();
        b.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // Need reference to YourClass here
            }
        });
    }
}