public Starter() throws InterruptedException {
    super("Editor");
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLocation(0, 0);
    setSize(WIDTH + 5, HEIGHT + 50);

    // **** REMOVE ****
    // setVisible(true); 

    setResizable(false);
    setLocation(80, 180);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    JPopupMenu.setDefaultLightWeightPopupEnabled(false);

    // **** ADD ****
    getContentPane().setLayout(null);   

    loadCaterogy(new EditorObjectProperties());

    // **** ADD ****
    setVisible(true);  
}