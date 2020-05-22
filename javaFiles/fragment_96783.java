if (!(device.isOpen())) {
    try {
      device.open();
  } catch (MidiUnavailableException e) {
          // Handle or throw exception...
  }
}