protected JSkinnableButton(){
    super();
    setLayout(new CardLayout()); // for interchangeability
    setMargin(new Insets(0,0,0,0));
    setBorder(BorderFactory.createEmptyBorder());
    add(new JSkinComponent(), "Skin");
}