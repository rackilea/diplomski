byte[] argb = ...
BitSet bits = BitSet.valueOf(argb);
bits.set(0); // sets the 0th bit to true
bits.clear(0); // sets the 0th bit to false

byte[] newArgb = bits.toByteArray();