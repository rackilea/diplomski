for (int x = 0; x < 10; x++) {
        for (int y = 0; y < 10; y++) {
            System.out.println(x + " * " + y + " = " + new BigInt(Integer.toString(x)).mul(new BigInt(Integer.toString(y))));

        }
    }