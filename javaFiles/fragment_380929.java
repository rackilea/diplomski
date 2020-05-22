Random random = new SecureRandom();

// If you use more than 100 here, then
// with your value of 486 for G you will
// end up with infinity when doing Math.pow(G,Xa).
// Of course, this does not provide enough possible
// values to be cryptographically secure.
int Xa = random.nextInt(100);
int Ya = (int) (Math.pow(G, Xa) % P);