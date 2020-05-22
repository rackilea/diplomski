public void actionPerformed(ActionEvent e) {
    try {
        File file = new File(listname + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int j = 0 ; j<list.getItemCount() ; j++)
        {
            String email1 =list.getItem(j).toString();
            printWriter.print(email1);
            printWriter.print("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    } catch (IOException l) {
    l.printStackTrace();
}