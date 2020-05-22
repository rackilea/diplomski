`SwingUtilities.invokeLater(new Runnable() {
        @Override
    public void run() {
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);
    }
});`