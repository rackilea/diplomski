final String st1 = "1005 random array 2.2";

final int idx1 = st1.indexOf(' ');
final int idx2 = st1.lastIndexOf(' ');    

final int a = Integer.valueOf(st1.substring(0, idx1)).intValue();
final char[] s2 = st1.substring(idx1, idx2).toCharArray();
final float b = Float.valueOf(st1.substring(idx2+1)).floatValue();