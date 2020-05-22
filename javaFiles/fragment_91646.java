BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    br.mark(1000); // mark a position

    int ch;
    if ((ch = br.read()) != -1) {
        // read once
    }

    br.reset(); // reset to the last mark

    if ((ch = br.read()) != -1) {
        // read again
    }