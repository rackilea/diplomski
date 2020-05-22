new Thread(() -> {
    try {
        System.out.println(Foogetter.call());
    } catch (Exception e) {
    }
}).start();