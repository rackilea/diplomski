String line = reader.readLine();

    while (line != null)
    {
        System.out.println("Read from stack: " + line);

        // we already read one element
        y.Push(line);
        line = reader.readLine();
    }