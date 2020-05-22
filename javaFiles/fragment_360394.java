public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton btn = (JToggleButton) e.getSource();
        System.out.println("clicked column " + btn.getClientProperty("column")
                + ", row " + btn.getClientProperty("row"));
}