SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        editor.scrollToReference("anchor6");
    }
});
JOptionPane.showMessageDialog(new JPanel(), scroller, "",
        JOptionPane.PLAIN_MESSAGE);