JCheckBox checkBox1 = new JCheckBox("Check1");
 JCheckBox checkBox2 = new JCheckBox("Check2");
 checkBox1.setName("Check1");
 checkBox2.setName("Check2");
 ItemListener listener = new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox check = (JCheckBox)e.getSource();
         String name = check.getName();
         System.out.println(name);
    }
};
checkBox1.addItemListener(listener);
checkBox2.addItemListener(listener);