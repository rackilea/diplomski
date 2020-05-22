@Override
    public Class<?> getColumnClass(int c) {
        if (c == 1) {
            return Short.class;
        } else {
            return Integer.class;
        }
    }