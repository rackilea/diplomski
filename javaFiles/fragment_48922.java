int amountToExpand = finalImage.length / pixels.length;
        for (int i = 0; i < finalImage.length; i++) {
            for (int j = 0; j < finalImage[i].length; j++) {
                finalImage[i][j] = pixels[i / amountToExpand][j / amountToExpand];
            }
        }