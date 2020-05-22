public Kraz() {
    initComponents();
    setVisible(true);
    game();
}

public Kraz(String check) {
    if (check.equals("editName"))
    {
        editName();
        setVisible(true);
    }
}