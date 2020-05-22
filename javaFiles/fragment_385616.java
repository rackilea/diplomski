BigInteger affineX = ((ECPublicKey) publicKey).getW().getAffineX();

BigInteger affineY = ((ECPublicKey) publicKey).getW().getAffineY();

printCoordinateInfo(affineX, "X");
System.out.println();
printCoordinateInfo(affineY, "Y");