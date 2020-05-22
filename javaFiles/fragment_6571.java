int result = r1X.compareTo(r2X);
if (result == 0) {
    result = r1Y.compareTo(r2Y);
}
if (result == 0) {
    result = r1Width.compareTo(r2Width);
}
if (result == 0) {
    result = r1Height.compareTo(r2Height);
}
return result;