public void write(final File file, final List<String> lines) throws IOException{
    final BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //new FileWriter(file, true) if you want to append the file (default is false)
    for(final String line : lines){
        writer.write(line);
        writer.newLine();
    }
    writer.flush();
    writer.close();
}