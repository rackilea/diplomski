public FigurePanel(int type) {
  if (type == DIE07) {
    this.type = DIE01 + rand.nextInt(DIE06);
  } else {
    this.type = type;
  }
}