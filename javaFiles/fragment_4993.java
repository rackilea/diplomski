String lines = read.readLine();

    while (lines != null)
    {
        System.out.println("Read from queue: " + lines);
        // we already read one line
        k.insert(lines);
        lines = read.readLine();
    }