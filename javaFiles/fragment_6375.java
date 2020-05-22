// initSeed is just zero valued bytes
byte[] initSeed = new byte[16];

SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
secureRandom.setSeed(initSeed);

byte[] seed = secureRandom.generateSeed(16);

byte[] data = new byte[16];
secureRandom.nextBytes(data);

System.out.printf("Seed: %s%n", Hex.toHexString(seed));
System.out.printf("Data: %s%n", Hex.toHexString(data));