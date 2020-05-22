final PiFace piface; { 
  try {
    piface = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, Spi.CHANNEL_0);
  } catch(IOException e) { 
    throw new RuntimeException("Failed to create Pi Face Device", e); 
  }
}