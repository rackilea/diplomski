public void createPanel3() {
      panel3 = new JPanel();
      panel3.setLayout(new BorderLayout());
      panel3.setPreferredSize(new Dimension(400, 100));
      panel3.setMinimumSize(new Dimension(100, 50));
      final JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fileChooser
               .setDialogTitle("Browse naar de  locatie waar je de gesorteerde bestanden wil zetten en klik op \"OPEN\"");
      panel3.add(fileChooser, BorderLayout.NORTH);
      fileChooser.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
               System.out.println("File selected: " + fileChooser.getSelectedFile());
            }
         }
      });
   }