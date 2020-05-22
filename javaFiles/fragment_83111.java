BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("2.txt"));
    Scanner sc = new Scanner(s);
    while (sc.hasNextInt()) {
        int b = sc.nextInt(2);
        out.write(b);
    }
    out.close();