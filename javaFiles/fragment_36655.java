List<Long> list = new ArrayList<>();
    String separator = System.getProperty("line.separator");
    int initialCapacity = 200000;
    StringBuilder sb = new StringBuilder(initialCapacity);
    for (long i = 0; i < 2000000; i++) {
        list.add(i);
        sb.append("Current size:").append(list.size()).append(separator);
        if (i % 10000 == 0 || i == 1999999) {
            System.out.println(sb);
            sb = new StringBuilder(initialCapacity);
        }
    }