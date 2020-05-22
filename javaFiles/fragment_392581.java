final JFileChooser fileChooser = new JFileChooser(new File("File to start in"));
    fileChooser.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            final String name = f.getName();
            return name.endsWith(".png") || name.endsWith(".jpg");
        }

        @Override
        public String getDescription() {
            return "*.png,*.jpg";
        }
    });
    fileChooser.showOpenDialog(GridCreator.this);