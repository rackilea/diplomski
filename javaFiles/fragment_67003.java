int myPort = buffer.get(0) & 0xff; // Might need to change this depending on byte order
  switch(myPort){
      case 0xF1: // Chat service
          break;
      case 0xF2: // Voice service
          break;
      case 0xF3: // Video service
          break;
      case 0xF4: // File transfer service
          break;
      case 0xF5: // Remote login
          break;
  }