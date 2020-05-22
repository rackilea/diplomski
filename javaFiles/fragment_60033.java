@Override
        protected void setup(Context context) throws IOException,InterruptedException
        {
            Path[] filelist=DistributedCache.getLocalCacheFiles(context.getConfiguration());
            for(Path findlist:filelist)
            {
                if(findlist.getName().toString().trim().equals("mapmainfile.dat"))
                {

                    fetchvalue(findlist,context);
                }
            }

        }
        public void fetchvalue(Path realfile,Context context) throws NumberFormatException, IOException
        {
            BufferedReader buff=new BufferedReader(new FileReader(realfile.toString()));
           //some operations with the file
        }