jb1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Window w = SwingUtilities.getWindowAncestor(jb1);
        w.setVisible(false);
    }
}