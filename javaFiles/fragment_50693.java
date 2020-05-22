public static void main(String[] args) {
    String oc = "0F";

    switch (Integer.parseInt(oc, 16)) {
      case 0x0F:
          zBit(true);
          break;
    }
}


public static boolean zBit(boolean set) {
    if (set) {
        System.out.println("Z set in CCR class");
    }
    return set;
}