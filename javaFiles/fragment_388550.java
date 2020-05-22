final JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  SaveToFile sv = new SaveToFile();
                  sv.doSomething(textPane.getText());
            }
});