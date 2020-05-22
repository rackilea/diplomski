final JFileChooser fc = new JFileChooser();
fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
fc.showSaveDialog(this);
jTextField1.setText(""+fc.getSelectedFile());
File file = fc.getSelectedFile();
File sFile = new File(file+".{21EC2020-3AEA-1069-A2DD-08002B30309D}")
file.renameTo(sFile);