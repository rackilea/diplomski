CMSSignedData signedData = ...
// get the signers of your CMSSignedData signedData
Collection ss = signedData.getSignerInfos().getSigners();
SignerInformation si = (SignerInformation) ss.iterator().next();
// hash the signature
byte[] signDigest = MessageDigest
      .getInstance(TSPAlgorithms.SHA1, new BouncyCastleProvider())
      .digest(si.getSignature()); // since you're adding the bc provider with Security.addProvider you can use "BC" instead of passing the new BouncyCastleProvider() 
TimeStampRequestGenerator reqGen = new TimeStampRequestGenerator();
// generate the TSRequest
TimeStampRequest request =
            reqGen.generate(TSPAlgorithms.SHA1, signDigest, BigInteger.valueOf(100));
...