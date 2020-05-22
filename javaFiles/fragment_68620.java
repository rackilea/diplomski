@Override
public int compareTo(MyViewModel another) {
    int enabledComparison = compare(isEnabled(), another.isEnabled());

    if (enabledComparison != 0) {
        return enabledComparison;
    }

    return compare(getPriority(), another.getPriority());
}

private static int compare(boolean a, boolean b) {
    if (a == b) {
       return 0;
    } else if (a) {
       return 1;
    } else {
       return -1;
    }
}

private static int compare(int a, int b) {
    if (a == b) {
        return 0;
    } else if (a > b) {
        return 1;
    } else {
        return -1;
    }
}