private static JavaEdit frame;
...
public JavaEdit() {
    ...
    saveMI = fileMenu.add(new MenuItem("Save"));
    saveMI.addActionListener(new SaveAction());
    ...
}

private static class SaveAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        FileDialog fDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        fDialog.setVisible(true);
        String path = fDialog.getDirectory() + fDialog.getFile();
        File f = new File(path);
        // f.createNewFile(); etc.
    }

public static void main(String[] argv) {
    // create frame
    frame = new JavaEdit();
    ...
    // show the frame
    frame.pack();
    frame.setVisible(true);
}