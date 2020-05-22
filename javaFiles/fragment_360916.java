fileItem1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Directories and XML files", "xml");
                        chooser.setFileFilter(filter);
                        int returnVal = chooser.showOpenDialog(this);
                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            String path = chooser.getSelectedFile().getAbsolutePath();
                            JOptionPane.showMessageDialog(null, "You selected" + path);
                        }
                    }
                });