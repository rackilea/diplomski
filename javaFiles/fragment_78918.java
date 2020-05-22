char sexoChar;

try {
    sexoChar = TxTSexo.getText().trim().charAt(0);
} catch (NullPointerException | IndexOutOfBoundsException e) {
    sexoChar = ' ';
}

C.setSexo(sexoChar);