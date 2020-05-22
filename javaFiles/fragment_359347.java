public Color getBackgroundColor(int row,String attributedName,Object value) {
    if (row%2==0)
         return new Color(255,255,255); /*sets White background for even rows*/
    else
    return new Color(238,238,238); /*sets Grey background for odd rows*/
}