for (int i = 0; i < currentNumBalls; i++) {
    try {
        this.aBall[i] = (Ball) Naming.lookup("rmi://localhost/BouncingBall"+i);

    } catch (Exception e) {
        System.out.println("Exception: " + e);
    }
}