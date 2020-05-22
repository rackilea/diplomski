public double getRoot0(){
    if (discriminant > 0) {
        return ( -b + Math.sqrt(discriminant)) / (2 * a);
    }
    return Double.NaN;
}