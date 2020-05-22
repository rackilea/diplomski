for (int i = 0; i < particleCount; i++) {
    if (boolArray[i]) { // boolArray is linked with particleArray, false
                        // means the linked particle has collided with
                        // another particle and no longer exists
        double iX = particleArray[i].getXPosition();
        double iY = particleArray[i].getYPosition();
        double iM = particleArray[i].getMass();
        for (int j = i + 1; j < particleCount; j++) {
            if (boolArray[j]) {
                double rX = iX - particleArray[j].getXPosition();
                double rY = iY - particleArray[j].getYPosition();
                double rT = Math.sqrt(rX * rX + rY * rY);
                double rF = rT * rT * rT;
                double fT = -constantGravity * iM * particleArray[j].getMass() / rF;
                particleArray[i].updateForce(rX * fT, rY * fT);
                particleArray[j].updateForce(-rX * fT, -rY * fT);
            }
        }
    }
}