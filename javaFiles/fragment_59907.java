class Synapse<T extends Cell> {
  private T cell;

  // some other methods... like isConnected

  public boolean getPreviousActiveState() {
    return this.cell.getPreviousActiveState(); // <= Compiles!
  }
}