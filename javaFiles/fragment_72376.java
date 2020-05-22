public void writeGridToFile() throws IOException {
        FileWriter fw = new FileWriter("D:/GridArrayFile.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        try {
           for(int i = 0; i < 100; i++){
                bw.write(GridArray[i]);
           }
        }
        catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error");
        }
        finally {
                bw.close();
                System.out.println("Finished");
        }
}