public static boolean willAdditionOverflow(int left, int right) {
    if (right < 0 && right != Integer.MIN_VALUE) {
        return willSubtractionOverflow(left, -right);
    } else {
        return (~(left ^ right) & (left ^ (left + right))) < 0;
    }
}

public static boolean willSubtractionOverflow(int left, int right) {
    if (right < 0) {
        return willAdditionOverflow(left, -right);
    } else {
        return ((left ^ right) & (left ^ (left - right))) < 0;
    }
}