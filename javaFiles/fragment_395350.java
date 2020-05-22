FileReader fileReader = new FileReader(fileName);
BufferedReader bufferedReader = new BufferedReader(fileReader);
FileWriter fstream = new FileWriter("out.txt");
BufferedWriter out = new BufferedWriter(fstream);
while ((line = bufferedReader.readLine()) != null) {
    try {
        out.write(line);
        out.write("\n");
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
    System.out.printf("%65s\n", line);
}
out.close();
bufferedReader.close();