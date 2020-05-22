File[] files = /**** list of files */
    HashMap<String, List<File>> hm = new HashMap<String, List<File>>();

    for(File file : files) 
    {
        if (file.isFile()) 
        {
            String fileName = file.getName().toString();
            String str = fileName.substring(5, 11);

            if(hm.containsKey(str))
            {
                hm.get(str).add(file);
            }
            else
            {
                List<File> al = new ArrayList<File>();
                al.add(file);
                hm.put(str, al);
            }
            fileName = null;
            str = null;
        }
    }