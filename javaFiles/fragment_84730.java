for(int i=0;i<8;i++)
    {
        for( int j=0;j<8;j++)
        {
            jp[i][j]=new MyJPanel(i,j);
            p.add(jp[i][j]);
            jp[i][j].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    MyPanel p = (MyPanel)e.getSource();
                    // p.i p.j
                }
            });
            this.allSquares.add(jp[i][j]); // adding panel in arraylist of type Jpanel
            if(j%2==0&&i%2==0)// code to change background color of panels for chess board
            {
            jp[i][j].setBackground(Color.DARK_GRAY);
            }
            if(j%2!=0&&i%2!=0)
            {
            jp[i][j].setBackground(Color.DARK_GRAY);
            }
        }
    }