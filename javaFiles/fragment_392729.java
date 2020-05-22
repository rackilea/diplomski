public static void main(String[] args) {
    try {

          File inFile = new File("C:\\rirubio\\books.txt");

          if (!inFile.isFile()) {
            System.out.println("Parameter is not an existing file");
            return;
          }

          //Construct the new file that will later be renamed to the original filename. 
          File tempFile = new File("C:\\rirubio\\books.txt" + "_temp");

          BufferedReader br = new BufferedReader(new FileReader(inFile));
          PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

          String line = null;

          String lineToRemove = JOptionPane.showInputDialog("Enter line to remove");

          //Read from the original file and write to the new 
          //unless content matches data to be removed.
          while ((line = br.readLine()) != null) {
            if (!line.trim().contains(lineToRemove)) {
              pw.println(line);
              pw.flush();
            }
          }

          pw.close();
          br.close();

          //Delete the original file
          if (!inFile.delete()) {
            System.out.println("Could not delete file");
            return;
          } 

          //Rename the new file to the filename the original file had.
          if (!tempFile.renameTo(inFile)) {
            System.out.println("Could not rename file");
          }

        } catch (FileNotFoundException ex) {
          ex.printStackTrace();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }