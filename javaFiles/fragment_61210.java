URL url = Main.class.getResource("/a.txt");
    System.out.println(url);
    URL url2 = Main.class.getResource("/text/b.txt");
    System.out.println(url2);
    URL url3 = Main.class.getResource("/other/c.txt");
    System.out.println(url3);