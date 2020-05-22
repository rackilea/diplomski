private void generateCSV(List<String> dataset) throws IOException {
    CSVWriter writer = null;
    JFileChooser chooser = new JFileChooser();
    chooser.setAcceptAllFileFilterUsed(true);
    if (chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
        File f = chooser.getSelectedFile();
        String file_name = f.toString();
        if (!(file_name.endsWith(".csv"))) {
            file_name += ".csv";
        }
        writer = new CSVWriter(new FileWriter(f));
        String[] str = new String[dataset.size()];
        for (int i = 0; i < dataset.size(); i++) {
            str[i] = dataset.get(i);
        }
        writer.writeNext(str);

    } else {
        return;
    }
    writer.close();
}