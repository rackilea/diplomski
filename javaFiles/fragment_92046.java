public boolean circleContainsCircle(Circle big, Circle small) {

    double segment_length = euler_distance(big.center, small.center) + 
        small.radius + big.radius;
    return (segment_length <= 2 * big.radius);

}