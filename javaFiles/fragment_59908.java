interface ActiveStateProvider {
  public boolean getPreviousActiveState();  
}

class Cell implements ActiveStateProvider {
  protected boolean wasActive;

  public Cell() {
    this.wasActive = false;
  }

  public boolean getPreviousActiveState() {
    return this.wasActive;
  }

  public void setPreviousActiveState(boolean previousActiveState) {
    this.wasActive = previousActiveState;
  }
}

class Synapse<T extends ActiveStateProvider> {
  private T cell;

  // some other methods... like isConnected

  public boolean getPreviousActiveState() {
    return this.cell.getPreviousActiveState(); // <= Compiles!
  }
}