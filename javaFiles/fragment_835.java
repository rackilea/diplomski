s = new Scanner(new BufferedReader(new FileReader(filename)));
        int x = 0;
        while (s.hasNext()) {
            text[x] += s.next();
            x++;
        }