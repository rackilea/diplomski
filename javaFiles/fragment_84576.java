static class Outputer {
    public void outPut( String name) {          
        int len = name.length();
        synchronized (Outputer.class) {      // Outputer.this is not the same as Outputer.class
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}