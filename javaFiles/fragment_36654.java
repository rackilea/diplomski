List<Long> list = new ArrayList<>();
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
        for(long i = 0; i < 2000000; i++) {
            list.add(i);
            bw.write("Current size:" + list.size());
            bw.newLine();
            if(i % 100 == 0 || i == 1999999) {
                bw.flush();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }