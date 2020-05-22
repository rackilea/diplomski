class Ocurrencia {

    int renglon, columna;

    public Ocurrencia(int renglon, int columna) {
        this.renglon = renglon;
        this.columna = columna;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[" + renglon + "," + columna + "]";
    }

    public static void main(String[] args) {
        LinkedList<Ocurrencia> prueba = new LinkedList();
        Ocurrencia prue = new Ocurrencia(2, 3);
        prueba.add(prue);

        for (Ocurrencia ocurrencia : prueba) {
            System.out.println(ocurrencia);
        }
    }
}