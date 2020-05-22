public static void save(CharSequence entryList)
    {
        BufferedReader read;
        BufferedWriter write;
        File file = new File("CBB.dat");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            read = new BufferedReader(new FileReader(file));
            String complete = "";
            String line = null;
            while ((line = read.readLine()) != null)
            {
                complete += line + "\n";
            }
            read.close();
            write = new BufferedWriter(new FileWriter(file));
            write.append(complete);
            write.append(entryList);
            write.flush();
            write.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }