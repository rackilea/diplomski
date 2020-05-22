String filePath;    // File path plus name and file extension
String directory;        // File directory
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        directory = fc.getSelectedFile().getName();
    } else {
        directory = "Error in selection";
    }
filePath = directory + "\\" + folderName;