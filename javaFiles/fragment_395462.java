// tuning parameters

// these sizes are relatively arbitrary
int seedBytes = 20;
int hashBytes = 20;

// increase iterations as high as your performance can tolerate
// since this increases computational cost of password guessing
// which should help security
int iterations = 1000;

// to save a new password:

SecureRandom rng = new SecureRandom();
byte[] salt = rng.generateSeed(seedBytes);

Pkcs5S2ParametersGenerator kdf = new Pkcs5S2ParametersGenerator();
kdf.init(passwordToSave.getBytes("UTF-8"), salt, iterations);

byte[] hash =
    ((KeyParameter) kdf.generateDerivedMacParameters(8*hashBytes)).getKey();

// now save salt and hash

// to check a password, given the known previous salt and hash:

kdf = new Pkcs5S2ParametersGenerator();
kdf.init(passwordToCheck.getBytes("UTF-8"), salt, iterations);

byte[] hashToCheck =
    ((KeyParameter) kdf.generateDerivedMacParameters(8*hashBytes)).getKey();

// if the bytes of hashToCheck don't match the bytes of hash
// that means the password is invalid