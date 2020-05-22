final JScrollPane scroll = new JScrollPane(code); // here you create scroll

// .....

open.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
      try {
        JFileChooser chooseFile = new JFileChooser();

        // ....

        // you add the same component here
        tabs.addTab(fileName, scroll);

        // ....

    }