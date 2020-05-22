JFrame frame = new JFrame();

            JFileChooser fc = new JFileChooser();

            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setFileFilter( new FileFilter(){

                @Override
                public boolean accept(File f) {
                    return f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "Any folder";
                }

            });

            fc.setDialogType(JFileChooser.SAVE_DIALOG);
            fc.setApproveButtonText("Select");

            frame.getContentPane().add(fc);


            frame.setVisible(true);