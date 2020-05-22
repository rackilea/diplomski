@Override
public int compareTo(MyViewModel another) {
    int enabledComparison = Boolean.compare(isEnabled(), another.isEnabled());

    if (enabledComparison != 0) {
        return enabledComparison;
    }

    return Integer.compare(getPriority(), another.getPriority());
}