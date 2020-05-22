private class CustomComparator implements Comparator<Spot> {
    @Override
    public int compare(Spot lhs, Spot rhs) {
        if (lhs.isStar == rhs.isStar) return 0;
        else if (lhs.isStar) return 1;
        return -1;
    }
}