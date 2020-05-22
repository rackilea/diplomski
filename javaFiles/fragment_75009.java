void copy(File source, File destination, boolean folderCreate) throws IOException {
        if(source.isDirectory()){
            File dest;
            if(folderCreate)
                dest=new File(destination,source.getName());
            else
                dest=destination;

            if(!dest.exists()){
               dest.mkdir();
            }

            for (String file : source.list()) {
               System.out.println(file);
               copy(new File(source, file), new File(dest, file), false);
            }
        } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(source)), "UTF-8"));
                Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(destination)), "UTF-8"));

                while(true) {
                String line = br.readLine(); if(line == null) break;
                bw.write(line);
                }

                br.close();
                bw.close();
        }       
}