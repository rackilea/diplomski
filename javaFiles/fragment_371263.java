jc.getActionMap().put("save", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\temp\\gameplay.dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(this);
            }
            System.out.println("Gameplay Saved");
        } catch (IOException e) {
            System.out.println("Error Saving");
        }
    }
});