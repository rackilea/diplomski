open.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            AssignToTransientPanel((JPanel) new NewAlbum());
            Container content = mainFrame.getContentPane();
            content.removeAll();
            content.add(transientPanel);
            content.validate();
            content.repaint();
        }
   });