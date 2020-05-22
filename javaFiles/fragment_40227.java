String[] array = {"8C", "D9", "26", "1D", "69", "B7", "96", "DB"};

byte[] bytes = new byte[array.length];
for ( int i = 0; i < array.length; i++ ) {
    bytes[i] = (byte)Integer.parseInt( array[i], 16 );
}