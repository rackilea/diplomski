Scanner in = null;
    PrintWriter out = null;
    try {
        // init input, output
        in = new Scanner(new File("InputFile.txt"));
        out = new PrintWriter(new File("OutputFile.txt"));
        // read input file line by line
        while (in.hasNextLine()) {
            out.print(in.nextLine());
            if (in.hasNextLine()) {
                out.print("<CONTROL_CHARACTER>");
            }
        }
    } finally {
        // close input, output
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }