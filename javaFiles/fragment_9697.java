JFileChooser input = new JFileChooser();
int result = input.showSaveDialog(this);
if (result == JFileChooser.APPROVE_OPTION) {
    createFile();
} else if (result == JFileChooser.CANCEL_OPTION) {
    System.out.println("Cancel was selected");
}