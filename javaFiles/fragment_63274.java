public void readManifest() throws IOException, Exception {
    byte[] fileBytes = FileUtils.readFileToByteArray(file);
    ByteArrayInputStream bis = new ByteArrayInputStream(fileBytes);
    BDecoder decoder = new BDecoder(bis, "UTF-8");
    BDict dict = decoder.decodeDict();
    Map<String, Object> valueMap = dict.getValue();
    infoMap = (Map<String, Object>) valueMap.get("info");
}

public String hash() throws Exception {
    if (hash == null) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BEncoder encoder = new BEncoder(baos, "UTF-8");
        encoder.encodeDict(infoMap);
        hash = DigestUtils.sha1Hex(baos.toByteArray());
    }
    return hash;
}