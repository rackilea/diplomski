final double cosTheta = Math.cos(theta);
final double sinTheta = Math.sin(theta);

for (int distance = xFrom; distance < len; distance += interval) {

    double distance_x = distance * cosTheta;
    double distance_y = distance * sinTheta;

    //int x_circle_pixel = convertToPixelCircleX(FromX_pixel, distance_x);
    //int y_circle_pixel = convertToPixelCircleY(y1_pixel, distance_y, y_ratio);
    int x_circle_pixel = convertToPixelX((int) distance_x, x_ratio);
    int y_circle_pixel = convertToPixelY(y1_pixel, (int) distance_y, y_ratio);

    g2d.drawOval(x_circle_pixel, y_circle_pixel, 10, 10);
}