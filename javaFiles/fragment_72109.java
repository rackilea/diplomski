public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        JButton btn = new JButton("...");
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                String path = Preferences.userNodeForPackage(TestPane.class).get("FileAccess.lastSelectedDirectory", null);
                if (path != null) {
                    File filePath = new File(path);
                    if (filePath.exists() && filePath.isDirectory()) {
                        fileopen.setCurrentDirectory(filePath);
                    }
                }
                fileopen.setMultiSelectionEnabled(true);
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File[] file = fileopen.getSelectedFiles();
                    System.out.println("You selected " + file.length + " files");
                    Preferences.userNodeForPackage(TestPane.class).put("FileAccess.lastSelectedDirectory", fileopen.getCurrentDirectory().getAbsolutePath());
                } else {
                    System.out.println("File access cancelled by user.");
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}