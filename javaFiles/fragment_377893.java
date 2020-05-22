try {
    File file = new File("testcase1.txt");
    Scanner sc = new Scanner(file);
    int x, y;
    while (sc.hasNextLine()) {
        x = sc.nextInt();
        y = sc.nextInt()
        graph.addVertex(x);
        graph.addAdjvex(x, y);
        System.out.println(x + " " + y);
    }
    sc.close();
} catch (Exception e) {
    e.printStackTrace();
}