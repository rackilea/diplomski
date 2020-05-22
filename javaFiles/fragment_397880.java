String osName = System.getProperty("os.name");
if (osName.toLowerCase().contains("mac")) {
  // It's a mac.
} else if (osName.toLowerCase().contains("win")) {
  // It's windows.
} else {
  // Other. Linux, AIX, etc.
}