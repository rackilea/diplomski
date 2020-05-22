StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line = reader.readLine();
        while (line != null) {
            builder.append(line.replaceAll("&(?!amp;)", "&amp;"));
            builder.append('\n');
            line = reader.readLine();
        }
    }
    String newText = builder.toString();