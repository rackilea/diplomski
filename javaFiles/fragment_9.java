static long daysBetween(LocalDate start, LocalDate end, Set<DayOfWeek> ignore) {
    long d1 = start.toEpochDay(), d2 = end.toEpochDay();
    if(d1 > d2) throw new IllegalArgumentException();
    if(ignore.isEmpty()) return d2 - d1;
    int incompleteWeek = 0;
    DayOfWeek startDoW = start.getDayOfWeek(), endDoW = end.getDayOfWeek();
    if(startDoW != endDoW) {
        for(int v1 = startDoW.getValue(), v2 = endDoW.getValue();
            v1 != v2 && d1 < d2; v1 = v1%7+1, d1++) {
                if(!ignore.contains(DayOfWeek.of(v1))) incompleteWeek++;
        }
    }
    return incompleteWeek + (d2 - d1) * (7 - ignore.size()) / 7;
}