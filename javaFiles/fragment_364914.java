/**
 * @param x coordinates of point to be tested 
 * @param t coordinates of apex point of cone
 * @param b coordinates of center of basement circle
 * @param aperture in radians
 */
static public boolean isLyingInCone(float[] x, float[] t, float[] b, 
                                    float aperture){

    // This is for our convenience
    float halfAperture = aperture/2.f;

    // Vector pointing to X point from apex
    float[] apexToXVect = dif(t,x);

    // Vector pointing from apex to circle-center point.
    float[] axisVect = dif(t,b);

    // X is lying in cone only if it's lying in 
    // infinite version of its cone -- that is, 
    // not limited by "round basement".
    // We'll use dotProd() to 
    // determine angle between apexToXVect and axis.
    boolean isInInfiniteCone = dotProd(apexToXVect,axisVect)
                               /magn(apexToXVect)/magn(axisVect)
                                 >
                               // We can safely compare cos() of angles 
                               // between vectors instead of bare angles.
                               Math.cos(halfAperture);


    if(!isInInfiniteCone) return false;

    // X is contained in cone only if projection of apexToXVect to axis
    // is shorter than axis. 
    // We'll use dotProd() to figure projection length.
    boolean isUnderRoundCap = dotProd(apexToXVect,axisVect)
                              /magn(axisVect)
                                <
                              magn(axisVect);
    return isUnderRoundCap;
}