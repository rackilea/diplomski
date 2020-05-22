for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            innerCells[i][j] = new JPanel();
            innerCells[i][j].setLayout(new BorderLayout());
            innerCells[i][j].setBorder(BorderFactory.createLineBorder(lineColor));
            innerCells[i][j].setBackground(backgroundColor);
            innerCells[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JPanel k = (JPanel) e.getSource();
                    JLabel l = new JLabel("", JLabel.CENTER);
                    int x = getRows();
                    int y = getCols();
                    for (int r = 0; r < getRows(); r++) {
                        for (int c = 0; c < getCols(); c++) {
                            if (innerCells[r][c] == k) {
                                x = r;
                                y = c;
                            }
                        }
                    }
                    if (k.getComponents().length == 0) {
                        if (array[x][y] == 0) {
                            l.setBackground(k.getBackground());
                            k.add(l);
                            k.setBackground(Color.white);
                            k.revalidate();
                        } else {
                            l.setBackground(k.getBackground());
                            k.add(l);
                            k.setBackground(Color.red);
                            playerhit++;
                            GameScreen.FinalWinner();
                            k.revalidate();
                        }
                        randomHits();

                    }
                }