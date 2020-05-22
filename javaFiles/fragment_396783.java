int perimeter = 0;  
Raster raster = source.getRaster();

for (int i=1; i<source.getHeight()-1; i++) {
    for (int j=1; j<source.getWidth()-1; j++) {
        if (raster.getSample(j, i, 0) == 0) {
            if (raster.getSample(j+1, i, 0) == 1
             || raster.getSample(j-1, i, 0) == 1
             || raster.getSample(j, i+1, 0) == 1
             || raster.getSample(j, i-1, 0) == 1) {
                perimeter++;
            }
        }
    }
}