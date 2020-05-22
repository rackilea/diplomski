public static int readFile() throws FileNotFoundException, IOException {

    JFileChooser fileChooser = new JFileChooser();
    int choice = JOptionPane.NO_OPTION;
    do {
        choice = JOptionPane.NO_OPTION;
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String report = BMIRecord.report(file);
            choice = JOptionPane.showConfirmDialog(null, report + "\n\nWould you like to try another file?", "BMI Calculations", JOptionPane.YES_NO_OPTION);
        }

    } while (choice == JOptionPane.YES_OPTION);

    return 0;
}