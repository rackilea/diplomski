public int countDays(Set<Month> months, int year) {
    int count = 0;
    for (Month month : months) {
        count += month.getDays(year);
    }
    return count;
}