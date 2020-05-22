Timestamp date1 = (Timestamp) row1.get("Creation Date");
Timestamp date2 = (Timestamp) row2.get("Creation Date");
int cmp = date1.compareTo(date2);
if (cmp == 0) {
    date1 = (Timestamp) row1.get("Resolved Date");
    date2 = (Timestamp) row2.get("Resolved Date");
    cmp = (date1 == null ? (date2 == null ? 0 : 1)
                         : (date2 == null ? -1 : date1.compareTo(date2)));
}
return cmp;