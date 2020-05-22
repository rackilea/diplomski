@Override
public int compareTo(Day d) {
    int cmp = Integer.compare(year, d.year);
    if (cmp == 0) cmp = Integer.compare(month, d.month);
    if (cmp == 0) cmp = Integer.compare(day, d.day);
    return cmp;
}