deltaLon = maxLon - minLon;
deltaLat = maxLat - minLat;
if (deltaLon != 0.0 && deltaLat != 0.0) {
    lonScale = (screenWidth - 1) / deltaLon;
    latScale = (screenHeight - 1) / deltaLat;
    x0 = - minLon * lonScale;
    y0 = maxLat * latScale;
    if (lonScale > latScale) {
        lonScale = latScale;
        x0 = ((screenWidth - 1) - (minLon + maxLon) * lonScale) / 2.0;
    } else {
        latScale = lonScale;
        y0 = ((screenHeight - 1) + (minLat + maxLat) * latScale) / 2.0;
    }
} else if (deltaLon != 0.0) {
    lonScale = (screenWidth - 1) / deltaLon;
    latScale = 0;
    x0 = - minLon * lonScale;
    y0 = (screenHeight - 1) / 2.0;
} else if (deltaLat != 0.0) {
    lonScale = 0;
    latScale = (screenHeight - 1) / deltaLat;
    x0 = (screenWidth - 1) / 2.0;
    y0 = maxLat * latScale;
} else {
    lonScale = 0;
    latScale = 0;
    x0 = (screenHeight - 1) / 2.0;
    y0 = (screenWidth - 1) / 2.0;
}