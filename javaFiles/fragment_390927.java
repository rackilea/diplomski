class MacroListener implements POIFSReaderListener {
  [...]

  @Override
  public void processPOIFSReaderEvent(POIFSReaderEvent event) {
    System.out.println("  Event: Name " + event.getName() + ", path "
            + event.getPath());
    if (event.getPath().toString().startsWith("\\Macros")
            || event.getPath().toString().startsWith("\\_VBA")
            || event.getPath().toString().contains("_VBA_")) {
        this.macroDetected = true;
    }
  }
}