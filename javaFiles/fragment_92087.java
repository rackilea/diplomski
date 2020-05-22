public void setDistanceTravelled( double distanceTravelled ) {
    this.distanceTravelled = distanceTravelled;
    this.gallonsSaved = distanceTravelled/mpg;
}

public double gallonsCalculated() {
    return this.gallonsSaved;
}