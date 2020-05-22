private int getChartX(double week) {
    return (int)Math.round(week * 93 + 32);
}

private int getChartY(double count) {
    return (int)Math.round(930 - count * 9.3);
}