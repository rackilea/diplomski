UMLModeler.getEditingDomain().runExclusive(new Runnable() {
    public void run() {
        Element root = null;
        try {
            root = UMLModeler.openModelResource(fileName);
        } catch (IOException e) {
            System.out.println("Error while opening model " + fileName + ": " + e.getMessage());
        }
    }
});