/**
   * This object has no resources to dispose of per se, but the
   * doc comments for the base method in java.awt.Graphics imply
   * that this object will not be useable after it is disposed.
   * So, we sabotage the object to prevent further use to prevent
   * developers from relying on behavior that may not work on
   * other, less forgiving, VMs that really need to dispose of
   * resources.
   */
  public void dispose() {
      surfaceData = NullSurfaceData.theInstance;
      invalidatePipe();
  }