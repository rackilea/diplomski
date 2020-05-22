Collections.sort(list, new Comparator<LoggerDetails>() {
    @Override
    public int compare(LoggerDetails o1, LoggerDetails o2) {
        if(o1.logger.startsWith("com.abc") && !o1.logger.startsWith("com.abc")) {
            return -1;
        }
        if (o1.logger.startsWith("com.abc") && !o1.logger.startsWith("com.abc")) {
            return -1;
        } -- I just copypasted your original code, this should definitely be vice versa
        return 0;
    }  
}.thenComparing(o -> o.logger, Comparator.naturalOrder()));