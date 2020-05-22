ProcessBuilder pb = new ProcessBuilder(
      "ping",
      ipText.getText(), 
      "-t", "-l",
      packetSizeText.getText());
 pb.redirectOutput(Redirect.to(outputFile));
 Process p = pb.start();