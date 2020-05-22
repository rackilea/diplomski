public static byte[] EncryptionToBytes(string str)
{
    using (var aes = new AesManaged())
    {
        aes.Key = new byte[] { 0x72, 0x8f, 0xaf, 0x34, 0xb6, 0x4c, 0xd5, 0x5c, 0x8d, 0x1d, 0x50, 0x02, 0x68, 0x02, 0x6f, 0xfb };
        aes.Mode = CipherMode.ECB;
        aes.Padding = PaddingMode.PKCS7;

        using (var ms = new MemoryStream())
        {
            using (var cs = new CryptoStream(ms, aes.CreateEncryptor(), CryptoStreamMode.Write))
            {
                byte[] data = Encoding.UTF8.GetBytes(str);
                cs.Write(data, 0, data.Length);
            }

            byte[] encrypted = ms.ToArray();
            return encrypted;
        }
    }
}

public static string DecryptionFromBytes(byte[] encrypted)
{
    using (var aes = new AesManaged())
    {
        aes.Key = new byte[] { 0x72, 0x8f, 0xaf, 0x34, 0xb6, 0x4c, 0xd5, 0x5c, 0x8d, 0x1d, 0x50, 0x02, 0x68, 0x02, 0x6f, 0xfb };
        aes.Mode = CipherMode.ECB;
        aes.Padding = PaddingMode.PKCS7;

        using (var ms2 = new MemoryStream())
        {
            using (var ms = new MemoryStream(encrypted))
            using (var cs = new CryptoStream(ms, aes.CreateDecryptor(), CryptoStreamMode.Read))
            {
                cs.CopyTo(ms2);
            }

            byte[] decrypted = ms2.ToArray();
            return Encoding.UTF8.GetString(decrypted);
        }
    }
}