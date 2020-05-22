for(int k = 0; k < slopes.size(); k++){
    if(slopes.get(k).isClimbing() == false){
        float tempWeight = (slopes.get(k).getzDiff() / highestFallZ);
        weight += tempWeight;
        float weightedValue = (slopes.get(k).getEndX() * tempWeight);
        float delta = weightedValue - highestFallX;
        highestFallX += delta / weight;
    }
}