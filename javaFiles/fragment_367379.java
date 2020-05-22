private static byte[] MakeOctetString(byte[] data)
{
    return MakeTagLengthValue(0x04, data);
}

private static byte[] s_integerZero = new byte[] { 0x02, 0x01, 0x00 };

private static byte[] ExportPrivateKeyInfo(RSA rsa)
{
    RSAParameters parameters = rsa.ExportParameters(true);

    return MakeSequence(
        s_integerZero,
        s_rsaAlgorithmId,
        MakeOctetString(
            MakeSequence(
                s_integerZero,
                MakeInteger(parameters.Modulus),
                MakeInteger(parameters.Exponent),
                MakeInteger(parameters.D),
                MakeInteger(parameters.P),
                MakeInteger(parameters.Q),
                MakeInteger(parameters.DP),
                MakeInteger(parameters.DQ),
                MakeInteger(parameters.InverseQ))));
}