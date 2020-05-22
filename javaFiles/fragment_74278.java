// Store both numbers in one byte
    byte firstNumber = 10;
    byte secondNumber = 15;
    final byte bothNumbers = (byte) ((firstNumber << 4) | secondNumber);

    // Retreive the original numbers
    firstNumber = (byte) ((bothNumbers >> 4) & (byte) 0x0F);
    secondNumber = (byte) (bothNumbers & 0x0F);