if(OS.contains("Mac"))

{
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String path = "/Users/" + user + "/Desktop";
            File folder = new File(path);

            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null && listOfFiles.length > 0) {
                StringBuffer sb = new StringBuffer(2000);
                for (int i = 0; i < listOfFiles.length; i++) {
                    String s = listOfFiles[i].getName();
                    sb.append(s).append(", ");
                }
                msgbox(sb.toString());

            } else {
                msgbox("No files in the folder " + path);
            }
        }
    }); 
}