public void actionPerformed (ActionEvent e){
    //...

    File save = new File("/home/bekk/Outline.txt");
    PrintWriter out = null;
    try {
        out = new PrintWriter(save); 
        out.println(Clientname);
        //...
    } catch (IOException exp) {
        JOptionPane.showMessageDialog(null, "Failed to save file", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            out.close();
        } catch (Exception exp) {
        }
    }
}