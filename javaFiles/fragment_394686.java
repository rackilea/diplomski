byte[] check = { (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44 };
byte[] check2 = { (byte) 0x12, (byte) 0x23, (byte) 0x34, (byte) 0x45 };

int i = 0;
for (; i < ARRAY.length; i++) {
    if (Arrays.equals(ARRAY[i], check)) {
        System.out.println("check[] found at index: " + i);
        break;
    }
}
if (i == ARRAY.length) {
    System.out.println("check[] not found");
}

for (i = 0; i < ARRAY.length; i++) {
    if (Arrays.equals(ARRAY[i], check2)) {
        System.out.println("check2[] found at index: " + i);
        break;
    }
}
if (i == ARRAY.length) {
    System.out.println("check2[] not found");
}