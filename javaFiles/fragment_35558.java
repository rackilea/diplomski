public void zoomIn() {
    oldScale = saveScale;

    if(saveScale<=maxScale)
    {
        saveScale += .5;
        matrix.setScale(saveScale, saveScale);
        setImageMatrix(matrix);
        invalidate();

        // Center the image
        // Center the image
        if(bmHeight>bmWidth)
        {
        redundantXSpace = width - (saveScale * bmWidth);
        redundantXSpace /= 2;
        }
        else 
        {
            redundantYSpace = height - (saveScale * bmHeight) ;
            redundantYSpace /= 2;
        }

        matrix.postTranslate(redundantXSpace , redundantYSpace );
        setImageMatrix(matrix);
        invalidate();
    }
}

public void zoomOut() {

    if(saveScale>=minScale)
    {
        saveScale -= .5;
        matrix.setScale(saveScale, saveScale);
        setImageMatrix(matrix);
        invalidate();

        // Center the image
        if(bmHeight>bmWidth)
        {
        redundantXSpace = width - (saveScale * bmWidth);
        redundantXSpace /= 2;
        }
        else 
        {
            redundantYSpace = height - (saveScale * bmHeight) ;
            redundantYSpace /= 2;
        }
        matrix.postTranslate(redundantXSpace , redundantYSpace );
        setImageMatrix(matrix);
        invalidate();
    }
}