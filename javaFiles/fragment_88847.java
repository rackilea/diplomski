public Hex2(int ID, int r, int x, int y) {
    super();
    this.ID = ID;
    hexagon = generateHex(r, x, y);
    addMouseListener(this);
}