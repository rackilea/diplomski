JFileChooser fc = new JFileChooser();
switch (fc.showOpenDialog(null)) {
    case JFileChooser.APPROVE_OPTION:
        File file= fc.getSelectedFile();
        BufferedReader br = null;
        try {
            input = new BufferedReader(new FileReader(file));
            jTextPane1.read(input, "READING FILE :-)");
        } catch (IOException exp) {
            exp.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception exp) {
            }
        }
        break;
}