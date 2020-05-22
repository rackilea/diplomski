Security.addProvider( new org.bouncycastle.jce.provider.BouncyCastleProvider() );

KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance( "ECGOST3410", "BC" );
keyPairGenerator.initialize( new ECGenParameterSpec( "GostR3410-2001-CryptoPro-A" ) );
KeyPair keyPair = keyPairGenerator.generateKeyPair();

org.bouncycastle.asn1.x500.X500Name subject = new org.bouncycastle.asn1.x500.X500Name( "CN=Me" );
org.bouncycastle.asn1.x500.X500Name issuer = subject; // self-signed
BigInteger serial = BigInteger.ONE; // serial number for self-signed does not matter a lot
Date notBefore = new Date();
Date notAfter = new Date( notBefore.getTime() + TimeUnit.DAYS.toMillis( 365 ) );

org.bouncycastle.cert.X509v3CertificateBuilder certificateBuilder = new org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder(
        issuer, serial,
        notBefore, notAfter,
        subject, keyPair.getPublic()
);
org.bouncycastle.cert.X509CertificateHolder certificateHolder = certificateBuilder.build(
        new org.bouncycastle.operator.jcajce.JcaContentSignerBuilder( "GOST3411withECGOST3410" )
                .build( keyPair.getPrivate() )
);
org.bouncycastle.cert.jcajce.JcaX509CertificateConverter certificateConverter = new org.bouncycastle.cert.jcajce.JcaX509CertificateConverter();
X509Certificate certificate = certificateConverter.getCertificate( certificateHolder );

KeyStore keyStore = KeyStore.getInstance( "JKS" );
keyStore.load( null, null ); // initialize new keystore
keyStore.setEntry(
        "alias",
        new KeyStore.PrivateKeyEntry(
                keyPair.getPrivate(),
                new Certificate[] { certificate }
        ),
        new KeyStore.PasswordProtection( "entryPassword".toCharArray() )
);
keyStore.store( new FileOutputStream( "test.jks" ), "keystorePassword".toCharArray() );