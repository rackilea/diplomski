BigData tmp = bigData;
while (tmp != null) {
    process(tmp);
    tmp = tmp.next;
}
bigData = null;