final String o1s;
final String o2s;

if (o1.startsWith("|")) {
    o1s = o1.substring(1);
} else {
    o1s = o1;
}

if (o2.startsWith("|")) {
    o2s = o2.substring(1);
} else {
    o2s = o2;
}

return o1s.compareTo(o2s);