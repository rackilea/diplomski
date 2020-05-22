public ImportWorkspace(){

    x = y = x2 = y2 = 0;
    setLayout(null);
    setBackground(Color.decode("#2a2e37"));
    setBounds(85, 0, screenSize.width-85, screenSize.height);
    //System.out.println("W: " + super.getWidth() + ", H: " + super.getHeight());
    ContentPanelWidth = getWidth();
    System.out.println(ContentPanelWidth);

    JLabel dataIcon =  new JLabel(new ImageIcon(new ImageIcon ("folder.png").getImage().getScaledInstance(256,256, Image.SCALE_DEFAULT)));
    dataIcon.setBounds((getWidth()/2)-128, (getHeight()/2)-200, 256, 256);
    add(dataIcon);

    JLabel askImport = new JLabel("No Data Files have been selected: To begin importing data please select a directory.");
    askImport.setFont(new Font("Helvetica", Font.PLAIN, 20));
    askImport.setForeground(Color.white);
    askImport.setBounds((getWidth()/2)-375, (getHeight()/2)+50, 750, 100);
    add(askImport);

    JButton selectDirectory = new JButton("Select Directory");
    selectDirectory.setBounds((getWidth()/2)-75, (getHeight()/2)+150, 150, 50); //+half of width or height
    add(selectDirectory);

    selectDirectory.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            removeAll();
            revalidate();
            //repaint();           //Removed this line. It is not necessary in this place. Will be re-added AFTER the `for` loop below...
            thumbnailList.clear(); //Added this line.
            setLayout(new FlowLayout(FlowLayout.LEFT));

            ImportingImages getImages = new ImportingImages();
            getImages.importFiles();

            File curDir = new File("");
            File[] files = curDir.listFiles();
            long noFiles = curDir.length();

            for (File f : files) {
                String fileName = f.getName();
                String hiddenFile = ".DS_Store";
                if (fileName.equals(hiddenFile)){
                    //System.out.println("Do nothing");
                } else {

                    String thumbnailPath = curDir + "/" + f.getName();
                    try {
                        BufferedImage thumbnailIcon = ImageIO.read(new File(thumbnailPath));
                        thumbnailList.add(thumbnailIcon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            repaint(); //Added this line! Now the newly loaded images shall be painted.

            MyMouseListener listener = new MyMouseListener();
            addMouseListener(listener);
            addMouseMotionListener(listener);

            //DisplayImages(thumbnailList, ContentPanelWidth);
        }
    });
}