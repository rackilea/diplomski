class Panel extends JPanel {
    ArrayList<String> TileTypes = new ArrayList<String>();
    public Panel() {
        //Loading array of Tile Types
        try {
            Scanner TileFileScanner = new Scanner(new File("TileTypes"));
            while(TileFileScanner.hasNext()) {
                TileTypes.add(TileFileScanner.nextLine());
            }
        } catch(FileNotFoundException e) {
            System.err.println("Tile Type file not found.");
        }

        //Creating 2D array of Rectangles
        xCoor = 20;
        for(int r = 0; r < rows; r++) {
            yCoor = 20;
            for(int c = 0; c < cols; c++) {
                recs[r][c] = new Rectangle(xCoor, yCoor, 18, 18);
                yCoor += 19;
            }
            xCoor += 19;
        }

        //Creating 2D array of cells
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                cells[r][c] = new Cell(recs[r][c], "f", activeImage);
                cells[r][c].image = floor;
                xCoor += 21;
            }
            xCoor = 0;
            yCoor += 21;
        }

        addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseReleased(MouseEvent e) {
                for(int r = 0; r < rows; r++) {
                    for(int c = 0; c < cols; c++) {
                        if (cells[r][c].getRect().contains(e.getX(), e.getY())) {
                            cells[r][c].tileCode = activeKey;
                            cells[r][c].image = activeImage;
                            //System.out.println("click registered");
                        }
                    }
                }
            }
        }); 
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g.setFont(new Font("Italic",Font.PLAIN, 25));
        g.drawString("Press Enter to save to file.", 1050, 50);

        //Tile Type key on the rigt side of the screen
        int y = 550;
        for(int i = 0; i < TileTypes.size(); i++) {
            g.drawString(TileTypes.get(i), 1050, y);
            y += 30;
        }

        //Drawing cells
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g.fillRect((int)cells[r][c].r.getX(), (int)cells[r][c].r.getY(),
                           (int)cells[r][c].r.getWidth(), (int)cells[r][c].r.getHeight());
                g.setColor(Color.BLACK);
            }
        }
        //Drawing the images stored in each cell object
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g.drawImage(cells[r][c].getImage(), cells[r][c].getX(), cells[r][c].getY(), this);
            }
        }
    }
}