/** Returns a number <0, 0, or >0 when dp1 displays a date <, =, or > dp2. */
public int compare(DatePicker dp1, DatePicker dp2) {
    int compare = dp1.getYear() - dp2.getYear();
    if (compare == 0) {
        compare = dp1.getMonth() - dp2.getMonth();
        if (compare == 0) {
            compare = dp1.getDay() - dp2.getDay();
        }
    }
    return compare;
}