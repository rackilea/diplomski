String name = null;
if (r == JFileChooser.APPROVE_OPTION) {
    name = chooser.getSelectedFile().getName();
}
try {
    if (name != null) {
        PrintWriter writer = new PrintWriter(name, "UTF-8");
        ...
    }
} catch