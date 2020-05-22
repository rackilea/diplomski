for (File file : corpus)
            { 
          File new_file= new File(dir,file.getName());  
                {
                if(!new_file.exists()){
                    new_file.createNewFile();
                    }
            }