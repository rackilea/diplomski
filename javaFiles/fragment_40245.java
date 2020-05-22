File dbFolder=new File("/data/data/yourpackagename/databases/");
            if(!dbFolder.exists())
            {
                dbFolder.mkdirs();
            }
            File dbFile = new File("/data/data/yourpackagename/databases/"+"dbfilename");
            if(!dbFile.exists() || dbFile.length()<=0)
            {
                dbFile.createNewFile();

                InputStream fIn=context.getAssets().open("QuizDB.jpeg");
                byte[] buffer =new byte[1024];
                FileOutputStream fout=new FileOutputStream(dbFile);
                int c=fIn.read(buffer);
                while (c!=-1)
                {
                    fout.write(buffer);
                    c=fIn.read(buffer);
                }
                fout.close();