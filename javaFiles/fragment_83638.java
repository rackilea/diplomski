for (int i = 0; i <= 100; i++) {
        File in = new File("t" + i + ".txt");
        if (in.exists()) {
            try (
                FileInputStream fis = new FileInputStream(in);
                FileOutputStream fos = new FileOutputStream("model" + i + ".txt")) {
                // write something on fos depending on fis;
            }
        }
    }