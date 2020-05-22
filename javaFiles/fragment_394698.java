// create a destination array that is the size of the two arrays
byte[] destination = new byte[ciphertext.length + mac.length];

// copy ciphertext into start of destination (from pos 0, copy ciphertext.length bytes)
System.arraycopy(ciphertext, 0, destination, 0, ciphertext.length);

// copy mac into end of destination (from pos ciphertext.length, copy mac.length bytes)
System.arraycopy(mac, 0, destination, ciphertext.length, mac.length);