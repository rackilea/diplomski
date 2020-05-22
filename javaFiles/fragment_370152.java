public int lookup()
    {     
        File folder = new File(c);       
        //File[] listOfFiles = folder.listFiles();
        int count = 0;

        if(folder.listFiles() == null)
        {            
            return count;            
        }

        for (File file : folder.listFiles())
        {
            String path = file.getPath();

            //in each directory print out the audio files
            if(path.contains(".mp3") || path.contains(".wav") || path.contains(".flac") || path.contains(".m4a") || path.contains(".ogg") || path.contains(".wma"))
            {
                System.out.println(path);   
                count++;                             
            }            

            //call method again if the file is a directory
            if (file.isDirectory())
            {
                count += new MusicGetter(path).lookup();               
            }           
        }
        return count;     
        System.out.println("count is" + count);        
    }