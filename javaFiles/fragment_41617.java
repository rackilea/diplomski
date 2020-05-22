final long now = System.currentTimeMillis();
Integer closest = Collections.min(matchMap.entrySet(), new Comparator<Map.Entry<Integer, Date>>() {
    @Override
    public int compare(Map.Entry<Integer, Date> e1, Map.Entry<Integer, Date> e2) {
        long diff1 = Math.abs(e1.getValue().getTime() - now);
        long diff2 = Math.abs(e2.getValue().getTime() - now);
        return Long.compare(diff1, diff2);
    }
}).getKey();