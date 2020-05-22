Scanner sf = new Scanner(new File("resources/abc.txt"));
    List<String> text = new ArrayList<String>();
    while (sf.hasNext()) {
        text.add(sf.nextLine());
    }
    sf.close();

    for (String str : text) {
        StringTokenizer sc = new StringTokenizer(str, " ");
        double sum = 0;
        int count = 0;
        String name = sc.nextToken();
        while (sc.hasMoreElements()) {
            sum += Integer.valueOf(sc.nextToken());
            count++;
        }
        System.out.println(name + ", average = " + (sum / count));
    }
}