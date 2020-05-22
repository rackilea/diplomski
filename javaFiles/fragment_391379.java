boolean printedMessage = false;
while (true) {
  millisUntilFinished = ...
  if (!printedMessage && millisUntilFinished < 10000) {
    System.out.println("Your message");
    printedMessage = true;
  }
}