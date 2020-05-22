avgLat = (maxLat + minLat) / 2.0;
cosFactor = Math.cos(avgLat);
if (deltaLon != 0.0 && deltaLat != 0.0) {
    if (lonScale > latScale * cosFactor) {
        lonScale = latScale * cosFactor;
        x0 = ((screenWidth - 1) - (minLon + maxLon) * lonScale) / 2.0;
    } else {
        latScale = lonScale / cosFactor;
        y0 = ((screenHeight - 1) + (minLat + maxLat) * latScale) / 2.0;
    }
}