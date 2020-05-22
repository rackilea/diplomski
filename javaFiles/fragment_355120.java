final JPanel panel=new JPanel(new BorderLayout());
 button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       DefaultTableModel model=new DefaultTableModel(data, column);
       JTable table=new JTable(model);
       panel.add(new JScrollPane(table));
       panel.revalidate();
    }
});