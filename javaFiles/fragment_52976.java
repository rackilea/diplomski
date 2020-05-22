PrintStream finalStream;
        TreeOutputStream tos;
        PrintStream out;

        out = new PrintStream("logs.txt");

        tos = new TreeOutputStream();
        tos.add(out);
        tos.add(System.out);
        finalStream = new PrintStream(tos);
        System.setOut(finalStream);