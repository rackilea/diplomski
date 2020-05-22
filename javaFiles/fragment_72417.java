public float getAltitude(float mapzoom){
    //this equation is a transformation of the angular size equation solving for D. See: http://en.wikipedia.org/wiki/Forced_perspective
    float googleearthaltitude;
    float firstPartOfEq= (float)(.05 * ((591657550.5/(Math.pow(2,(mapzoom-1))))/2));//amount displayed is .05 meters and map scale =591657550.5/(Math.pow(2,(mapzoom-1))))
    //this bit ^ essentially gets the h value in the angular size eq then divides it by 2
    googleearthaltitude =(firstPartOfEq) * ((float) (Math.cos(Math.toRadians(85.362/2)))/(float) (Math.sin(Math.toRadians(85.362/2))));//85.362 is angle which google maps displays on a 5cm wide screen
    return googleearthaltitude;
}