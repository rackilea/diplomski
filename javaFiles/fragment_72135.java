public static void main(String[] args) {
    double[] x; // Señal de entrada (en nuestro caso es un tono puro a 250 Hz)
    int bufferSize = 1024;
    int fs = 44100;
    double f0 = ((float) fs / (float) bufferSize);
    System.out.println("f0 =  " + f0);

    x = GSignals.generateTone(bufferSize, fs, f0); // Generamos la señal de entrada
} // main()