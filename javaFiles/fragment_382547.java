browseBtn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if (accept(file)) {
                    try {
                        ImageIcon image = new ImageIcon(file.getPath());
                        label.setIcon(image);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error reading file !");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Choose png file only !");
                } 
            }
        }

        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".png");
        }


    });