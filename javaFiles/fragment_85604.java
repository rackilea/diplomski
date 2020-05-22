public Integer crackAlice() {
        // TODO
        Integer alicePrivate = 0;

        int p = session.getP();
        int g = session.getG();
        int A = session.getAlicesPublicKey();
        // A = g^a mod p


        System.out.println("Alice public A: "+A);
        String message = String.valueOf(156215);

        for (int i = 1; i < p; i++) {
            if (BigInteger.valueOf(g).pow(i).mod(BigInteger.valueOf(p)).equals(BigInteger.valueOf(A))) {
                //System.out.println("\t\t\t\t"+BigInteger.valueOf(g).pow(i));
                alicePrivate = i;
                System.out.println("Potential Alice private a: "+i);
                //break;
            }
        }
        return alicePrivate;
    }