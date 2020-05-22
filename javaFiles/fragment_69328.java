for (int i = 0; i < usb.length; i++) {
    System.out.println("Give fileName : ");
    String fileName = scannerUserInput.getString();
    System.out.println("Give minutes : ");
    double minutes = scannerUserInput.getDouble();
    System.out.println("Give memorySpace");
    double memorySpace = scannerUserInput.getDouble();
    ekpaideytikoYliko tempEkpaideytikoYliko = new ekpaideytikoYliko(fileName, minutes, memorySpace);
    usb[i] = tempEkpaideytikoYliko;
}