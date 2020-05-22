String base64 = "RALCgjQwMDA5wrNJb1QNAGNvYXBfbm9zZWNfMDEHZGVmYXVsdBEyIBRydD0yITLDncOiBElvVC9jb2FwX25vc2VjXzAxHQMxMjM0NS0wMDc3Nzg5Nzk5bShjb2FwOi8vMTkyLjE2OC4yNTAuMTE6MTU2ODUvSW9UL2NvYXBfbm9zZWNfMDEvZGVmYXVsdEEEw797Im0ybTpjaW4iOnsiY29uIjoiRXhhbXBsZUNJTiJ9fQ==";

byte[] bytes = Base64.getDecoder().decode(base64);

StringBuilder sbHexDump = new StringBuilder();
    for(byte b : bytes){
        sbHexDump.append(String.format("%02x", b));
    }
System.out.println(sbHexDump.toString());