public void run() {
        boolean a1 = false;
        boolean a2 = false;
        boolean a3 = false;
        while (true) {
            try (Closeable r1 = new Region(res[1])) {
                 a1 = true;
                 try (Closeable r2 = new Region(res[2])) {
                     a2 = true;
                     try (Closeable r3 = new Region(res[3])) {
                          a3 = true;
                          System.out.println("Rolled the tobacco");
                     } catch (IOException e) {
                     }
                 } catch (IOException e) {
                 }
            } catch (IOException e) {
            }
       }