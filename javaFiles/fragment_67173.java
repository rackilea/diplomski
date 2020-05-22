BufferedReader br = null;
try {        
    br = new BufferedReader(new FileReader(file));

    while((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (FileNotFoundException fnfe) {
    JOptionPane.showMessageDialog(null, fnfe.getMessage());
    return;
} catch (IOException ex) {
     ex.printStackTrace();
} finally {
    try {
        // Best effort to close the reader...
        br.close();
    } catch (Exception exp) {}
}