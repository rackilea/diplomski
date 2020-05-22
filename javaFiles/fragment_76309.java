JFrame frame = new JFrame("Welcome!");
frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to exit?");
        if (option == JOptionPane.OK_OPTION) {
            e.getWindow().dispose();
        }
    }
});