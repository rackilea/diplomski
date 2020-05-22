public void write(final File file, final List<String> lines) throws IOException{
    final BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //new FileWriter(file, true) if you want to append the file (default is false)
    lines.forEach(
            l -> {
                try{
                    writer.write(l);
                    writer.newLine();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
    );
    writer.flush();
    writer.close();
}