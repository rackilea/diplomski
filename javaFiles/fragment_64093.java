public String getAccountKey()
{
    String accountKey = "My Microsoft Azure Account Key";
    byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
    String accountKeyEnc = new String(accountKeyBytes);
    return accountKeyEnc;
}