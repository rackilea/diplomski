BufferedWriter out = null;

try {
    FileWriter fstream = new FileWriter("out.txt", true); //true tells to append data.
    out = new BufferedWriter(fstream);
    out.write("\nsue");
}

catch (IOException e) {
    System.err.println("Error: " + e.getMessage());
}

finally {
    if(out != null) {
        out.close();
    }
}