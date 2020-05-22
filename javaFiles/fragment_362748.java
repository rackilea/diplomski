if (m.find()) {
    int count = m.groupCount();
    for (int i=0; i<count; i++) {
        System.out.println(m.group(i));
    }
}