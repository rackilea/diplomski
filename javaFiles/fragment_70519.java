final static File RESULT_FOLDER = new File("target/test-outputs", "signature");

@BeforeClass
public static void setUpBeforeClass() throws Exception
{
    RESULT_FOLDER.mkdirs();
    BouncyCastleProvider provider = new BouncyCastleProvider();
    Security.addProvider(provider);
}

@Test
public void testSignLikeXinDHA() throws GeneralSecurityException, IOException, XMPException
{
    String path = "keystores/demo-rsa2048.p12";
    char[] pass = "demo-rsa2048".toCharArray();

    KeyStore ks = KeyStore.getInstance("pkcs12", "SunJSSE");
    ks.load(new FileInputStream(path), pass);
    String alias = "";
    Enumeration<String> aliases = ks.aliases();
    while (alias.equals("demo") == false && aliases.hasMoreElements())
    {
        alias = aliases.nextElement();
    }
    PrivateKey pk = (PrivateKey) ks.getKey(alias, pass);
    Certificate[] chain = ks.getCertificateChain(alias);

    try ( InputStream resource = getClass().getResourceAsStream("/mkl/testarea/itext7/content/test.pdf"))
    {
        sign(resource, new File(RESULT_FOLDER, "test_XinDHA_signed_initial.pdf").getAbsolutePath(),
                chain, pk, DigestAlgorithms.SHA1, /*"SunJSSE"*/"BC", PdfSigner.CryptoStandard.CMS, "Test", "Test",
                null, null, null, 0, true);
    }
}

public void sign(InputStream src, String dest, Certificate[] chain, PrivateKey pk, String digestAlgorithm,
        String provider, PdfSigner.CryptoStandard subfilter, String reason, String location,
        Collection<ICrlClient> crlList, IOcspClient ocspClient, ITSAClient tsaClient, int estimatedSize,
        boolean initial)
        throws GeneralSecurityException, IOException, XMPException
{
    // Creating the reader and the signer

    PdfDocument document = new PdfDocument(new PdfReader(src), new PdfWriter(dest + "_temp"));
    if (initial == true)
    {
        document.addNewPage();
    }
    int pageCount = document.getNumberOfPages();
    document.close();
    PdfSigner signer = new PdfSigner(new PdfReader(dest + "_temp"), new FileOutputStream(dest), true);
    // Creating the appearance
    if (initial == true)
    {
        signer.setCertificationLevel(PdfSigner.CERTIFIED_FORM_FILLING_AND_ANNOTATIONS);
    }
    PdfSignatureAppearance appearance = signer.getSignatureAppearance().setReason(reason).setLocation(location)
            .setReuseAppearance(false);
    Rectangle rect = new Rectangle(10, 400, 100, 100);
    appearance.setPageRect(rect).setPageNumber(pageCount);
    appearance.setRenderingMode(RenderingMode.NAME_AND_DESCRIPTION);
    signer.setFieldName(signer.getNewSigFieldName());
    // Creating the signature
    IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
    ProviderDigest digest = new ProviderDigest(provider);
    signer.signDetached(digest, pks, chain, crlList, ocspClient, tsaClient, estimatedSize, subfilter);
}