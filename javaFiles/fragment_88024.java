Security.addProvider(new BouncyCastleProvider());
KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
kpg.initialize(256);
KeyPair kp = kpg.generateKeyPair();
byte[] ourPk = kp.getPublic().getEncoded();
System.out.println("ourPk len is " + ourPk.length);

ASN1Sequence sequence = DERSequence.getInstance(ourPk);

DERBitString subjectPublicKey = (DERBitString) sequence.getObjectAt(1);

byte[] subjectPublicKeyBytes = subjectPublicKey.getBytes();

System.out.println("EC key length : " + subjectPublicKeyBytes.length);