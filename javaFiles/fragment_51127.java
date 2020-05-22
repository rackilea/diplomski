public class FileSystemTreeCellRenderer implements TreeCellRenderer {
    protected Color foregroundColor = null;
    protected Color backgroundColor = null;
    protected Color selectionForegroundColor = null;
    protected Color selectionBackgroundColor = null;
    protected Map<Object, JLabel> labels = new HashMap<>();
    protected final Icon  folderSpecial;
    protected final Icon  folderOther;
    protected final Icon  fileSpecial;
    protected final Icon  fileOther;

    public FileSystemTreeCellRenderer() throws IOException {
        InputStream stream;
        BufferedImage image;

        stream = new FileInputStream("folder-special.png");
        image = ImageIO.read(stream);
        folderSpecial = new ImageIcon(image);
        stream.close();

        stream = new FileInputStream("folder-other.png");
        image = ImageIO.read(stream);
        folderOther = new ImageIcon(image);
        stream.close();

        stream = new FileInputStream("file-special.png");
        image = ImageIO.read(stream);
        fileSpecial = new ImageIcon(image);
        stream.close();

        stream = new FileInputStream("file-other.png");
        image = ImageIO.read(stream);
        fileOther = new ImageIcon(image);
        stream.close();
    }

    protected JLabel getLabelFor(Object object) {
        JLabel label = labels.get(object);
        if(label == null) {
            label = new JLabel();
            labels.put(object, label);
        }
        return label;
    }

    public Color getForegroundColor() {
        if (foregroundColor == null) return UIManager.getColor("Tree.textForeground");
        return foregroundColor;
    }

    public Color getBackgroundColor() {
        if (backgroundColor == null) return UIManager.getColor("Tree.textBackground");
        return backgroundColor;
    }

    public Color getSelectionForegroundColor() {
        if (selectionForegroundColor == null) return UIManager.getColor("Tree.selectionForeground");
        return selectionForegroundColor;
    }

    public Color getSelectionBackgroundColor() {
        if (selectionBackgroundColor == null) return UIManager.getColor("Tree.selectionBackground");
        return selectionBackgroundColor;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JLabel label = getLabelFor(value);
        label.setText(Objects.toString(value, ""));
        label.setOpaque(true);
        label.setBackground(selected ? getSelectionBackgroundColor() : getBackgroundColor());
        label.setForeground(selected ? getSelectionForegroundColor() : getForegroundColor());
        label.setEnabled(tree.isEnabled());
        label.setComponentOrientation(tree.getComponentOrientation());

        if (value instanceof File) {
            Icon icon = null;
            File file = (File) value;

            if (file.isDirectory()) {
                if (file.getName().endsWith("-special")) {
                    icon = folderSpecial;
                } else {
                    icon = folderOther;
                }
            } else if (file.isFile()) {
                if (file.getName().endsWith(".special")) {
                    icon = fileSpecial;
                } else {
                    icon = fileOther;
                }
            }

            label.setIcon(icon);
        }

        return label;
    }
}