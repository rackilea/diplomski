if (next.isEmpty()) {
    listLocation++;
}
if (listLocation == 0) {
    Main.branch = next;
}else if (listLocation == 1) {
    Main.staff.add(next);
}else if (listLocation == 2) {
    Main.customers.add(next);
}
listLocation++;
// ^^^ remove this line