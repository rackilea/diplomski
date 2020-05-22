ArrayList<String> paths = new ArrayList<String>();
    JFileChooser fc = new JFileChooser();
    fc.setMultiSelectionEnabled(true);
    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    fc.showOpenDialog(fc);
    File[] file = fc.getSelectedFiles();
    for (File f : file) {
        System.out.println(f.getAbsolutePath());
        try {
            Files.walk(Paths.get(f.getAbsolutePath())).filter(Files::isRegularFile)
                    .forEach(p -> paths.add(p.toString()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    System.out.println(paths);