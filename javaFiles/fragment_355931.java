@Override
public int hashCode() {
    int res = 17;
    res = res * 31 + Math.min(from, to);
    res = res * 31 + Math.max(from, to);
    return res;
}