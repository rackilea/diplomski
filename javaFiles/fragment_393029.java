private readonly bool allowSsl;

// callback used to validate the certificate in an SSL conversation
private static bool ValidateRemoteCertificate(
object sender,
    X509Certificate certificate,
    X509Chain chain,
    SslPolicyErrors policyErrors
)
{
    if (allowSsl)
    {
        // allow any certificate...
        return true;
    }
    else
    {
        return policyErrors == SslPolicyErrors.None;
    }
}