public void notifyStateChange() {
        for (int i = 0; i < count; i++) {
            if (creatures[i] instanceof Animal) {
                System.out.println("Animal type here");
            }
        }
    }