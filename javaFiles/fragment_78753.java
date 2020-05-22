CoordBoutons() {
       super("GridLayout");
       setDefaultCloseOperation(EXIT_ON_CLOSE);     
       getContentPane().setLayout(new GridLayout(8, 8));
       for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               getContentPane().add(new CaseEchiquier(i, j));
            }
        }
        pack();
        setVisible(true);
 }