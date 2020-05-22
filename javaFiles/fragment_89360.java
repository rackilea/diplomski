r2 = (int)(r2*0.3);
    g2 = (int)(g2*0.3);
    b2 = (int)(b2*0.3);
    imageOut.setIntColor(x, y,  (int)((r1*factorImage+r2*factorMask)),
                                (int)((g1*factorImage+g2*factorMask)),
                                (int)((b1*factorImage+b2*factorMask)));