...
if (response.equals("A")) {
    Collections.sort(elist, (o1, o2) -> Integer.compare(o1.getP(), o2.getP()));
}
else if (response.equals("D")) {
    Collections.sort(elist, (o1, o2) -> Integer.compare(o2.getP(), o1.getP()));
}
...