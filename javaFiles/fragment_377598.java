while((enter = in.read()) != -1) {
    String binary = Integer.toBinaryString(enter);
    // left-pad to length 8
    binary = ("00000000" + binary).substring(binary.length());
    code += binary;
}