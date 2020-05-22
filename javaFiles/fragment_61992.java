import static java.lang.Math.*;

public static double perfectCity(double x1, double y1, double x2, double y2) {
    double xDist = abs(x1 - x2);
    double yDist = abs(y1 - y2);
    if (floor(x1) != x1 && floor(x2) != x2 &&        // both Xs are doubles
        floor(x1) == floor(x2)) {                    // on the same block
        xDist = min(abs(x1 - floor(x1) + x2 - floor(x2)),
                    abs(x1 - ceil(x1)  + x2 - ceil(x2)));
    } else if (floor(y1) != y1 && floor(y2) != y2 && // both Ys are doubles
               floor(y1) == floor(y2)) {             // on the same block
        yDist = min(abs(y1 - floor(y1) + y2 - floor(y2)),
                    abs(y1 - ceil(y1)  + y2 - ceil(y2)));
    }
    return xDist + yDist;
}