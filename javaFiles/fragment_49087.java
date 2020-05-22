float xySum = 0;
float xSqSum = 0;
float xSum = 0;
float ySum = 0;
for (Point point: points) {
    xySum += point.x * point.y;
    xSqSum += point.x * point.x;
    xSum += point.x;
    ySum += point.y;
}
float xMean = xSum / count;
float yMean = ySum / count;
float n = points.size();
float slope = (xySum - n* xMean * yMean) / (xSqSum - n * xMean * xMean);