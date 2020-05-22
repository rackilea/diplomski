while (index < noXSemiCircles)
    {
        cs.saveGraphicsState();
        Matrix mt = Matrix.getTranslatingInstance(leftX + (index * 10), bottomY);
        AffineTransform at = mt.createAffineTransform();
        cs.concatenate2CTM(at);
        DrawSlice(cs, 5, 180, 270, true);
        DrawSlice(cs, 5, 270, 360, true);
        cs.stroke();
        cs.restoreGraphicsState();
        index++;
    }