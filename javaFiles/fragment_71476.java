public float linearInterpolation(float start, float end, float normalizedValue) {
    return start + (end - start) * normalizedValue;
}

public float sinInterpolation(float start, float end, float normalizedValue){
    return (start+(end-start)* (1 - Math.cos(normalizedValue * Math.PI)) / 2;
}

//usage
linearInterpolation(red, green, .5f);//halfway between red and green.
//same with other demonstrations.