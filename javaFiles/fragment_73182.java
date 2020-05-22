public static float findAverageMagnitude(List<Earthquake> earthquakes) {
    float total = 0.0f;
    for(Earthquake earthquake : earthquakes) {
        total += earthquake.getMagnitude();
    }
    return total / earthquakes.size();
}