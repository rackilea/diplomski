int limit;
try {
    limit = Integer.parseInt(stuff[0]);
}
catch(ArrayIndexOutOfBoundsException e) {
    limit = getInt("Limit? ");
}
int[] p = getPrimes(limit);