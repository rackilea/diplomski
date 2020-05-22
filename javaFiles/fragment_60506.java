private NdefRecord createWifiRecord(String[] data) {
    String ssid = data[0];
    String password = data[1];
    String auth = data[2];
    String crypt = data[3];
    byte[] authByte = getAuthBytes(auth);
    byte[] cryptByte = getCryptBytes(crypt);
    byte[] ssidByte = ssid.getBytes();
    byte[] passwordByte = password.getBytes();
    byte[] ssidLength = {(byte)((int)Math.floor(ssid.length()/256)), (byte)(ssid.length()%256)};
    byte[] passwordLength = {(byte)((int)Math.floor(password.length()/256)), (byte)(password.length()%256)};
    byte[] cred = {0x00, 0x36};
    byte[] idx = {0x00, 0x01, 0x01};
    byte[] mac = {0x00, 0x06};
    byte[] keypad = {0x00, 0x0B};

    byte[] payload = concat(NFCHelper.CREDENTIAL, cred,
            NFCHelper.NETWORK_IDX, idx,
            NFCHelper.NETWORK_NAME, ssidLength, ssidByte,
            NFCHelper.AUTH_TYPE, NFCHelper.AUTH_WPA_PERSONAL, authByte,
            NFCHelper.CRYPT_TYPE, NFCHelper.CRYPT_WEP, NFCHelper.CRYPT_AES_TKIP,
            NFCHelper.NETWORK_KEY, passwordLength, passwordByte);
           // NFCHelper.MAC_ADDRESS, mac);
    return NdefRecord.createMime(NFC_TOKEN_MIME_TYPE, payload);
}