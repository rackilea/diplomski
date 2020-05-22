for (int i = 0; i < w * h; i++) {
        Color c = new Color(inicial[i]);
        resultadoR[i] = c.getRed();
        resultadoG[i] = c.getGreen();
        resultadoB[i] = c.getBlue();
    }

    int k = 0;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            procesarR[i][j] = resultadoR[k];
            procesarG[i][j] = resultadoG[k];
            procesarB[i][j] = resultadoB[k];
            k++;
        }
    }

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {

            procesarBN[i][j] = (int) (0.2989 * procesarR[i][j] + 0.5870 * procesarG[i][j] + 0.1140 * procesarB[i][j]);

        }
    }