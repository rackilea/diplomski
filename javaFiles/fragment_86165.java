if (obj instanceof Integer[]) {
    Integer[] array = (Integer[]) obj;
    /* Use the boxed array */
} else if (obj instanceof int[]) {
    int[] array = (int[]) obj;
    /* Use the primitive array */
} else ...