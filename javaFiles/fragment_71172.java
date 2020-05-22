File[] files = new File("/tmp/smsrouter/").listFiles();

    for (File file : files) {
        if (file.isDirectory()||!file.getName().startsWith("45-")) {
            continue;
        } else {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int count = 0;
            int lineNumber = 0;
            while((line=br.readLine())!=null)
            {
                String[] parts = line.split("\\,");

                lineNumber++;
                if(parts[3].equals("0") && count < lineNumber)
                {
                    count++;
                }
            }
            count = (count/lineNumber)*100;
            br.close();
        }
    }