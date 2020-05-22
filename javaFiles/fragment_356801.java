public byte[] toBytes(boolean[] input) {
    byte[] toReturn = new byte[input.length / 8];
    for (int entry = 0; entry < toReturn.length; entry++) {
        for (int bit = 0; bit < 8; bit++) {
            if (input[entry * 8 + bit]) {
                toReturn[entry] |= (128 >> bit);
            }
        }
    }

    return toReturn;
}