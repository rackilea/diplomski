public static WaterBody mostPowerful(WaterBody[] waterBodies) {
    double maxValue = -1;
    int indexOfMaxValue = -1;
    for(int i = 0; i < waterBodies.length; i++) {
        if(waterBodies[i].getElectricPower() > maxValue) {
            indexOfMaxValue = i;
        }
    }
    return waterBodies[indexOfMaxValue];
}