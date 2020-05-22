Collections.sort(_C, new Comparator<Customer>() {
    @Override
    public int compare(Customer c1, Customer c2) {
        int openTimeDiff = c1.getOpenTime() - c2.getOpenTime();
        if (openTimeDiff != 0)
            return openTimeDiff;
        return c1.getCloseTime() - c2.getCloseTime();
    }
});