while (in.hasNextLine()) {
        String line = in.nextLine();
        if (!line.isEmpty()) {
            line = "0" + line.substring(0, 2) + "-" + line.substring(2, 4);
        }
        out.println(line);
    }