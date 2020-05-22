private String message = "Do u want to save this file ?"

int reply = JOptionPane.showConfirmDialog(null, "message", "title",JOptionPane.YES_NO_OPTION);
if (reply == JOptionPane.YES_OPTION) {
    save(this.textArea.getText(), save.getSelectedFile().getPath()));
}else {
    //what you need
}

private void save(String content, String path) {
        try{
            BufferedWriter out = new  BufferedWriter(newFileWriter(path) );
            out.write(content);
            out.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }`enter code here`
    }