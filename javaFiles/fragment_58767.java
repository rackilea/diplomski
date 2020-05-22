SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("world");
            }
        });
        System.out.println("hello");
    }
});