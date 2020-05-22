public double distance(Point other) {

        double d = Math.pow(other.getX()- getX(), 2) + Math.pow(other.getY() - getY(), 2);

        return Math.sqrt(d); 
}