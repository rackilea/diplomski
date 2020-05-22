JFileChooser sumtin = new JFileChooser();
if(sumtin.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
{
        File filer = sumtin.getSelectedFile();
        field.fromFile(filer.getName());
        sudokuGrid.setText(field.toString());
        mainWindow.revalidate();
        mainWindow.repaint();
}