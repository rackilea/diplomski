public void notifyStateChange() {
    for (int i = 0; i < count; i++) {
        Class c = creatures[i].getClass();
        if (c.getSimpleName().equals("Animal")) {
            System.out.println("Animal type here");
        }
    }
}