double[][] Coeficientes;
List<double[]> temp = new ArrayList<>();

for(int i=0; i<longVector-LventanaReal; i+=saltos){
    double[] VectorCoeficientes = CalcularCoeficientes(i);
    temp.add(VectorCoeficientes);
}

Coeficientes = temp.toArray(new double[temp.size()][13]);