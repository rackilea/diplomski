public void updateFile(ArrayList<UserInformation> data) {
    PrintWriter pw;
    try {
        pw = new PrintWriter(new FileWriter("AllUserRecords.txt"));
        for (UserInformation userinf : data) {
            String line = userinf.getID()
                    + "     " + userinf.getFname()
                    + "     " + userinf.getLname()
                    + "     " + userinf.getGender()
                    + "     " + userinf.getDate();

            pw.println(line);
        }
        pw.close();
    } catch (IOException ioe) {
    }
}