@Override
    public int compare(HDTV tv1, HDTV tv2) {

        System.out.println("Comparing " tv1.getSize() + " to " tv2.getSize())

        int tv1Size = tv1.getSize();
        int tv2Size = tv2.getSize();

        if (tv1Size > tv2Size) {
            return 1;
        } else if (tv1Size < tv2Size) {
            return -1;
        } else {
            return 0;
        }
    }