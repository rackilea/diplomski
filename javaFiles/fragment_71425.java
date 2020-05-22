int[] a = { this.parkDate.getYear(), this.parkDate.getMonth(), 
        this.parkDate.getDay(), this.parkDate.getHours(), 
        this.parkDate.getMinuets() };
int[] b = { v.parkDate.getYear(), v.parkDate.getMonth(), 
        v.parkDate.getDay(), v.parkDate.getHours(), 
        v.parkDate.getMinuets() };
for (int i = 0; i < a.length; i++) {
    int rv = Integer.compare(a[i], b[i]);
    if (rv != 0) {
        return rv;
    }
}
return 0;