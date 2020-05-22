class COMP implements Comparator<Items> {
    @Override // overides compareTo() method
    public int compare(Items a1, Items a2) {
        if (a1.getType() < a2.getType()) {
            return 1;
        } else if (a1.getType() > a2.getType()) {
            return -1;
        } else if (a1.getDiff() < a2.getDiff()) {
            return 1;
        } else if (a1.getDiff() > a2.getDiff()) {
            return -1;
        } else if (a1.getDays() < a2.getDays()) {
            return 1;
        } else if (a1.getDays() > a2.getDays()) {
            return -1;
        }
        return 0;
    }
}