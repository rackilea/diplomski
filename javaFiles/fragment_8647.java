public static void main(final String[] args) throws FileNotFoundException, IOException {
    if (!SwingUtilities.isEventDispatchThread()) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    main(args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return;
    }

    ...
}