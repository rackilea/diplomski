// Create the W point
ECPoint w = new ECPoint(x, y);

// Create the ECField from hey integer (p)
ECField field = new ECFieldFp(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16));

// Create the EllipticCurve with a and b
EllipticCurve curve = new EllipticCurve(field, new BigInteger("0"), new BigInteger("7"));

// Create the G point:
BigInteger gx = new BigInteger("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16);
    BigInteger gy = new BigInteger("483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", 16);
ECPoint g = new ECPoint(gx, gy);

// Create ECParameterSpec
ECParameterSpec spec = new ECParameterSpec(curve, new ECPoint(gx, gy), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16), 1);

// Create the KeySpec:
KeySpec keySpec = new ECPublicKeySpec(w, spec);

// Generate the key
KeyFactory keyFactory = KeyFactory.getInstance("EC");
PublicKey key = keyFactory.generatePublic(keySpec);