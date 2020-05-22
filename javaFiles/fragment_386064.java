int[][] countries = { { -34, -7 }, { 76, -23 }, { -5, -20 }, { -56, 64 }, { 12, 56 } };

double maxDistance = 0;
for (int i = 0; i < countries.length - 1; ++i) {
    int x1 = countries[i][0];
    int y1 = countries[i][1];
    for (int j = i; j < countries.length; ++j) { // first j will be i
        int x2 = countries[j][0];
        int y2 = countries[j][1];
        double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        maxDistance = maxDistance < distance ? distance : maxDistance;
    }
}
System.out.println(maxDistance);