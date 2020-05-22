public int aboveAverage() {   
    int greatAvgCount = 0;
    for (int i = 0; i < fishCaught.length; i++) {
        if (fishCaught[i] > 3.1) {
            greatAvgCount++; // no 'return'
        }
    }
    return greatAvgCount;
}