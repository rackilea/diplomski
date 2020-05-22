public static void requireInRange(int index, Object[] array) {
   ...
}

int[] anArray = {3, 4, 2};
requireInRange(3, anArray); // DOES NOT COMPILE!!!