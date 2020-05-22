/**
 * Genera un tono puro.
 * @param bufferSize Tamaño del buffer.
 * @param fs Frecuencia de muestreo.
 * @param f0 Frecuencia central. 
 * @return El tono puro.
 */
public static double[] generateTone(int bufferSize, int fs, double f0) {
    double[] tone = new double[bufferSize]; // Tono
    double angle; // Ángulo del tono

    for (int i = 0; i < tone.length; i++) {
        angle = 2 * Math.PI * f0 * i / fs; // Calculamos la variación del ángulo
        tone[i] = Math.sin(angle); // Cada muestra se obtiene a partir del seno del ángulo
    }

    return tone;
} // generateTone()