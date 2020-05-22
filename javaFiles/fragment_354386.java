class OpenActionListener_open implements ActionListener {

    JFileChooser chooser;

    OpenActionListener_open() {
        chooser = new JFileChooser();
    }

    public void actionPerformed(ActionEvent e) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".java files", "java");
        chooser.setFileFilter(filter);

        int ret = chooser.showOpenDialog(null);
        if (ret != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "File Unchoose.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fileName = chooser.getSelectedFile().getName();
        JTextArea ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        tp.addTab(fileName, sp);

        String filePath = chooser.getSelectedFile().getPath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String data = "";
            while ((data = reader.readLine()) != null) {
                ta.append(data + "\n");
            }
            reader.close();
        } catch (IOException e1) {
        }
        tp.setSelectedComponent(sp);

    }
}