public void generateTXTOnSD(String[] lines_txt) 
{
    // lines_txt contains an array of each register in CSV format.
    try
    {
        File root = new File(Environment.getExternalStorageDirectory(),"NameOfDirectoryYouWantToSave");
        if (!root.exists()) 
        {
            root.mkdirs();
        }
        Calendar cal = Calendar.getInstance();
        // I made this to no override early versions of data I have stored.
        String hour= String.valueOf(cal.get(cal.HOUR_OF_DAY))+"_"+String.valueOf(cal.get(cal.MINUTE))+"_"+String.valueOf(cal.get(cal.SECOND));
        File txtfile = new File(root, name_txt+hour+".txt");
        FileWriter writer = new FileWriter(txtfile);
        //Every line contain the info you want to save
        for (String line_txt : lines_txt) {
            writer.append(line_txt);
            writer.append('\r');
            writer.append('\n');

        }
        writer.flush();
        writer.close();


    }
    catch(IOException e)
    {
        // ERROR

    }
}