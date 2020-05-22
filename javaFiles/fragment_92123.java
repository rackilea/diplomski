SmbFile file = null;
byte[] buffer = new byte[1024];
try {
    String url = "smb://"+serverAddress+"/"+sharename+"/TEST.txt";
    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, username, password);
    file = new SmbFile(url, auth);
    try (SmbFileInputStream in = new SmbFileInputStream(file)) {
        int bytesRead = 0;
        do {
            bytesRead = in.read(buffer)
            // here you have "bytesRead" in buffer array
        } 
        while (bytesRead > 0);
    }
} catch(Exception e) {
    JOptionPane.showMessageDialog(null, "ERROR: "+e);
}