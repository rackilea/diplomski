//file f;  
   JFileChooser fc = new JFileChooser();
     fc.showSaveDialog(this);
      f=fc.getSelectedFile();
      if(f!=null)
    {
        try {
            PrintWriter pw = new PrintWriter(f);
            System.out.println(jTextArea1.getText());
            pw.print(jTextArea1.getText());
            pw.close();
        } catch (FileNotFoundException ex) {}
}