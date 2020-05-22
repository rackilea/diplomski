start.add(Calendar.DAY_OF_MONTH, (int)diffDays);
while (start.before(end)) {
    start.add(Calendar.DAY_OF_MONTH, 1);
    diffDays++;
}
while (start.after(end)) {
    start.add(Calendar.DAY_OF_MONTH, -1);
    diffDays--;
}