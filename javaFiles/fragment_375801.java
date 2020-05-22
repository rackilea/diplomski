if (figure == 2) {
        if (ptsReta.size() %2 == 0) {
            for (int b = 0; b < ptsReta.size(); b = b + 2) {
                Reta retinha = new Reta(ptsReta.get(b), ptsReta.get(b + 1));
                guardaRetas.add(retinha);
            }

            if (guardaRetas.size() > 0) {
                for (int r = 0; r < guardaRetas.size(); r++) {
                    canvas.drawLine(guardaRetas.get(r).pinicial.x, guardaRetas.get(r).pinicial.y, guardaRetas.get(r).pfinal.x, guardaRetas.get(r).pfinal.y, paint);
                }
            }
        }
    }