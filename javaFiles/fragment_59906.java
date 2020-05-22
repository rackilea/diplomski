class Synapse<T> {
  private T cell;

  // some other methods... like isConnected

  public boolean getPreviousActiveState() {
    return this.cell.getPreviousActiveState(); // <= CAN'T BE CALLED. WHY?
  }
}