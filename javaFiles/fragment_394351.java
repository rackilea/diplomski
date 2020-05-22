open.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

daughterWindow.setResizable(false);
daughterWindow.pack();
daughterWindow.setVisible(true);         

if(open.showOpenDialog(daughterWindow) == JFileChooser.APPROVE_OPTION){