if(LAST_FOLDER_USED != null){
            jFileChooser1.setCurrentDirectory(new File(prefs.get(LAST_FOLDER_USED, LAST_FOLDER_USED)));
        }
        else{
            jFileChooser1.setCurrentDirectory(new java.io.File("/Users/benwoodruff/Desktop"));
        }
jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
    jFileChooser1ActionPerformed(evt);

    folder_Location = jFileChooser1.getCurrentDirectory().toString();
    prefs.put(LAST_FOLDER_USED, folder_Location);
    //System.out.println(prefs.get(LAST_FOLDER_USED, folder_Location));
  }
});