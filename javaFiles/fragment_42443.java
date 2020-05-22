BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"));

for (int i = 0; i < linesToWrite; i++){
    writer.write(updatedLine);
    writer.newLine();
}
writer.close();