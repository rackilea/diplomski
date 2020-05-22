ECKeyPairGenerator gen = new ECKeyPairGenerator("ECDSA");
        SecureRandom secureRandom = new SecureRandom();
        Org.BouncyCastle.Asn1.X9.X9ECParameters ecp = Org.BouncyCastle.Asn1.Sec.SecNamedCurves.GetByName("secp224k1");
        ECDomainParameters ecSpec = new ECDomainParameters(ecp.Curve, ecp.G, ecp.N, ecp.H, ecp.GetSeed());
        ECKeyGenerationParameters ecgp = new ECKeyGenerationParameters(ecSpec, secureRandom);
        gen.Init(ecgp);
        AsymmetricCipherKeyPair eckp = gen.GenerateKeyPair();