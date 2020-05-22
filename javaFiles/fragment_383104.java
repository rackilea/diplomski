Color overrideBrightness(Color c , float factor){
    if(factor < 0)
        throw new IllegalArgumentException("Factor must be positive");

    float[] components = c.getComponents();

    return new Color(Math.min(components[0] * factor , 1.0) , 
                     Math.min(components[1] * factor , 1.0) ,
                     Math.min(components[2] * factor , 1.0) , 
                     components[3]);
}