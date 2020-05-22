double calculateDistance(
  double longitude1, double latitude1, 
  double longitude2, double latitude2) {
    double c = 
        Math.sin(Math.toRadians(latitude1)) *
        Math.sin(Math.toRadians(latitude2)) +
            Math.cos(Math.toRadians(latitude1)) *
            Math.cos(Math.toRadians(latitude2)) *
            Math.cos(Math.toRadians(longitude2) - 
                Math.toRadians(longitude1));
    c = c > 0 ? Math.min(1, c) : Math.max(-1, c);
    return 3959 * 1.609 * 1000 * Math.acos(c);
}