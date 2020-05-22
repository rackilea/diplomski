public void SaveFile()
{
    try {
            //Getting Internal Storage
            File file = new File(Environment.getExternalStorageDirectory(),"");
            File dfile = new File(file+"/data.txt");
            FileWriter write = null;
            //if File Does Exists
            if (!dfile.exists()) {
                write = new FileWriter(file+"/data.txt");
                write.write("1");
                write.close();
            }
            else{
                FileReader read = new FileReader(dfile);
                BufferedReader br = new BufferedReader(read);
                String snum = br.readLine();
                if(snum!=null) {
                    //Converting Sring to Integer
                    int num = Integer.parseInt(snum);
                    num++;
                    write = new FileWriter(file+"/data.txt");
                    write.write(String.valueOf(num));
                    write.close();
                }
                else
                {                    
                    write = new FileWriter(file+"/data.txt");
                    write.write("1");
                    write.close();
                }
            }
        }catch (IOException ex){}
}