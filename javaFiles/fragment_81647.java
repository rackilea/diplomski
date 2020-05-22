BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\ngueno\\Desktop\\File 1.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\ngueno\\Desktop\\File 2.txt"), StandardOpenOption.WRITE);

        String line;

        while( (line = reader.readLine()) != null ) {
            writer.write(line);
        }

        reader.close();
        writer.flush();
        writer.close();