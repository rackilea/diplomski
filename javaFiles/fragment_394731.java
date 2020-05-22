/*
 * this is a refactored method, instead of a constructor
 */
public SafePoint cloneSafePoint(SafePoint originalSafePoint){
     int [] xy = originalSafePoint.getXY();
     return new SafePoint(xy[0], xy[1]);    
}