public Integer(String s) throws NumberFormatException {
this.value = parseInt(s, 10);
}

public static int parseInt(String s) throws NumberFormatException {
return parseInt(s,10);
}