private String ReadFilefromNAS(String s, String Username, String Password) {
    //s is the filename path on the NAS
    String file = "";
    SmbFile dir;
    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, Username, Password);
        dir = new SmbFile(FilePath + s, auth);
        //If your not using auth use the below
        //dir = new SmbFile(FilePath + s);
        InputStream in = dir.getInputStream();
        BufferedReader q= new BufferedReader(new InputStreamReader(in));
        String line;
        int i = 0;
        while ((line = q.readLine()) != null) {
            if(i==0){
                file+=line;
            }else {
                file += "\n" + line;
            }
            i+=1;
        }
    }catch(Exception e){
        Log.e("ERROR",e.toString());
    }
    return file;
}