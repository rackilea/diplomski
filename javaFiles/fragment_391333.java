public class DesktopUI {

    private Path pathDirectChoose ;
    private final File root = new File("/");
    private File des;
    private JTree rightTree; // declare as object property

    public DesktopUI(){
        initUI();
    }
    public void setPathDirectChoose(Path pathDirectChoose){
        this.pathDirectChoose = pathDirectChoose;
    }
    public void setDes(String des){
        this.des = new File(des);
        rightTree.setModel(new FileTreeModel(des));
    }

    private void initUI(){
        JFrame frame = new JFrame("TestProject");
        //make TopMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu optionMenu = new JMenu("Option");
        JMenuItem chooseSecretFolder = new JMenuItem("Choose Secret Folder");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpItem = new JMenuItem("?Help");
        JMenuItem aboutItem = new JMenuItem("About");

        // config chooseSecretFolder
        chooseSecretFolder.setToolTipText("Choose destinaion folder to encrypt");
        chooseSecretFolder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
        chooseSecretFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedDirect = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(fileChooser);
                selectedDirect = fileChooser.getSelectedFile();
                setPathDirectChoose(selectedDirect.toPath());
                setDes(String.valueOf(pathDirectChoose));
                System.out.println(String.valueOf(pathDirectChoose));

            }
        });

        //add ActionListener for exit Item
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        optionMenu.add(chooseSecretFolder);
        optionMenu.add(exitItem);
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        menuBar.add(optionMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        //make JTextField to show PathFile choosed and view Tree
        JTextField pathFileJText = new JTextField();
        JTree leftTree = new JTree(new FileTreeModel(root));
        rightTree = new JTree(new FileTreeModel(des)); // no type declaration here
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JScrollPane leftPane = new JScrollPane(leftTree);
        JScrollPane rightPane = new JScrollPane(rightTree);
        //add TreeSelectionListener for tree system
        leftTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object object = e.getPath().getLastPathComponent();
                System.out.println(object);
                pathFileJText.setText(object.toString());
                // make a popupMenu when file be choosed
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem encryptFile = new JMenuItem("Encrypt File");
                JMenuItem decryptFile = new JMenuItem("Decrypt File");
                popupMenu.add(encryptFile);
                popupMenu.add(decryptFile);

                leftTree.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        if (e.getButton() == MouseEvent.BUTTON3){
                            popupMenu.show(e.getComponent(),e.getX(),e.getY());

                        }
                    }
                });
            }

        });

        //show all componets
        splitPane.setLeftComponent(leftPane);
        splitPane.setRightComponent(rightPane);
        frame.add(pathFileJText,BorderLayout.NORTH);
        frame.add(splitPane,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    }




    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DesktopUI desktopUI = new DesktopUI();
            }
        });

    }
}