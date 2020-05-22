public void doOperation(int dimension, int numSol, double[] tresDimenciones, double[] mejorSolucion) {
    for (int i = 0; i < numSol; i++) {
        for (int j = 0; j < dimension; j++) {
            if (tresDimenciones[j] < mejorSolucion[j]) {
                mejorSolucion[j] = tresDimenciones[j];
            }
        }
        System.out.println("///////////Corrida " + i);
        System.out.println("Primera:" + tresDimenciones[0] + "\nSegunda:" + tresDimenciones[1] + "\ntercera:" + tresDimenciones[2]);
    }
}