COSArray verticesArray = new COSArray();

for (int i = 0; i < coordinates.length; i++) {
    verticesArray.add(new COSFloat(coordinates[i]));
}

// new / changed
COSArray verticesArrayArray = new COSArray();
verticesArrayArray.add(verticesArray);
freehand.getCOSObject().setItem(COSName.INKLIST, verticesArrayArray);