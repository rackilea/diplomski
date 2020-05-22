List<int> getUniqueColors(int amount) {
    final int lowerLimit = 0x10;
    final int upperLimit = 0xE0;    
    final int colorStep = (upperLimit-lowerLimit)/Math.pow(amount,1f/3);

    final List<int> colors = new ArrayList<int>(amount);

    for (int R = lowerLimit;R < upperLimit; R+=colorStep)
        for (int G = lowerLimit;G < upperLimit; G+=colorStep)
            for (int B = lowerLimit;B < upperLimit; B+=colorStep) {
                if (colors.size() >= amount) { //The calculated step is not very precise, so this safeguard is appropriate
                    return colors;
                } else {
                    int color = (R<<16)+(G<<8)+(B);
                    colors.add(color);
                }               
            }
    return colors;
}