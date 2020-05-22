String coords= "3,1.2,0.1,1.0,2.1,3.2,3.3,3.";
    for (int i = 0, j = 0; i < coords.length(); i = j + 1) {
        j = coords.indexOf(".", i);
        if (j == -1) break;
        int k = coords.indexOf(",", i);
        int x = Integer.parseInt(coords.substring(i, k));
        int y = Integer.parseInt(coords.substring(k + 1, j));
        System.out.printf("X:%d, Y:%d%n", x, y);
    }