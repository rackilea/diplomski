double G = 42;
int P = 26;


Random random = new SecureRandom();
int Xa = random.nextInt(100);
double val = Math.pow(G, Xa);
System.out.println("Xa: " + Xa);
System.out.println("(double) Math.pow: " + val + " (int): " + (int) val);
int Ya = (int) (val % P);
System.out.println("Ya: " + Ya);