JFileChooser chooser = new JFileChooser();
chooser.setMultiSelectionEnabled(true);
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "png", "jpg", "jpeg");
chooser.setFileFilter(filter);

switch (chooser.showOpenDialog(null)) {

    case JFileChooser.APPROVE_OPTION:

        String currentPath = chooser.getCurrentDirectory().getPath();
        File[] files = chooser.getSelectedFiles();

        if (files.length > 0) {

            System.out.println("You have choosen " + files.length + " from " + currentPath);

        } else {

            System.out.println("You didn't selected anything");

        }

        break;

}