@Override
protected void subAppend(E event) {
    setFileName();
    this.setFile(fileName);
    start();
    super.subAppend(event);
}