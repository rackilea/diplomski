public Integer crackBob() {
        // TODO

        Integer bobPrivate = 0;
        Integer a = crackAlice();
        int p = session.getP();
        int g = session.getG();
        int A = session.getAlicesPublicKey();
        String mainMessage = "teade";

        String msg = null;
        try {
            msg = session.getEncrypted(mainMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i < p; i++) {
            int ai = a*i;
            int Ai = A*i;
            //System.out.println("a*b = "+ai);
            BigInteger bigintP = BigInteger.valueOf(p);
            if (((BigInteger.valueOf(g).pow(a).mod(bigintP)).pow(i)).mod(bigintP)
                    .equals(((BigInteger.valueOf(g).pow(i).mod(bigintP)).pow(a)).mod(bigintP))) {
                String decrypt = null;
                try {
                    decrypt = session.getDecryptedWithCustomKey(msg, BigInteger.valueOf(g).pow(a*i).mod(bigintP).intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (decrypt != null && decrypt.trim().equals(mainMessage)) {
                    bobPrivate = i;
                    break;
                }
            }
        }
        return bobPrivate;
    }