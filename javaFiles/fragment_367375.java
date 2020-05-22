private static byte[] s_prefix =
{
    0x30, 0x82, 0x01, 0x22,
          0x30, 0x0D,
                0x06, 0x09, 0x2A, 0x86, 0x48, 0x86, 0xF7, 0x0D, 0x01, 0x01, 0x01,
                0x05, 0x00,
          0x03, 0x82, 0x01, 0x0F,
                0x00,
                0x30, 0x82, 0x01, 0x0A,
                      0x02, 0x82, 0x01, 0x01, 0x00
};

private static byte[] s_suffix = { 0x02, 0x03, 0x01, 0x00, 0x01 };

private static byte[] MakeSubjectPublicInfoEasy2048(RSA rsa)
{
    if (rsa.KeySize != 2048)
        throw new ArgumentException(nameof(rsa));

    RSAParameters rsaParameters = rsa.ExportParameters(false);

    if (Convert.ToBase64String(rsaParameters.Exponent) != "AQAB")
    {
        throw new ArgumentException(nameof(rsa));
    }

    return s_prefix.Concat(rsaParameters.Modulus).Concat(s_suffix).ToArray();
}