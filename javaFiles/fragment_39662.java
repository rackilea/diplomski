try{
            String user = "your_user_name";
            String pass ="your_pass_word";
            String sharedFolder="shared";

            String url = "smb://ip_address/" + sharedFolder + "/test.txt";
                        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(
                                null, user, pass);
                        SmbFile sfile = new SmbFile(url, auth);
    }catch(Exception e){
    }