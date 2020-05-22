try (PrintWriter out = new PrintWriter(new FileWriter("login.txt", false));) {

        for (int i = 0; i < 10; i++) {
            out.println(i);
        }

    } catch (IOException e) {
      System.out.println(e);
    }