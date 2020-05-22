public void leggiFile() {
    Alunno a;
    try {
        FileInputStream f = new FileInputStream("istituto.dat");
        try {
            while (true) {
                // the header is read in the constructor
                ObjectInputStream fIN = new ObjectInputStream(f);
                a = (Alunno) fIN.readObject();
                dim++;
                System.out.println("Dimensione file: " + dim);
            }
        } catch (EOFException e) { }
        f.close();
    } catch (Exception e) {
        System.out.println("Eccezione lettura: " + e.getMessage());
    }
}