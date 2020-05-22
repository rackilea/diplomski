NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("domain", "username", "password");
        SmbFile smbFile = new SmbFile("//path", auth);
        InputStream in;
        if (smbFile.exists()) {
            in = smbFile.getInputStream();
        }