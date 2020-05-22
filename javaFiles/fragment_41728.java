private boolean isAlignedWithGravity(IntersectionPointPlaneModelPair pair,
                                     TangoPoseData devicePose) {
    Matrix4 adfTdevice = ScenePoseCalculator.tangoPoseToMatrix(devicePose);
    Vector3 gravityVector = ScenePoseCalculator.TANGO_WORLD_UP.clone();
    adfTdevice.clone().multiply(mExtrinsics.getDeviceTDepthCamera()).inverse().
            rotateVector(gravityVector);

    double[] gravity = new double[]{gravityVector.x, gravityVector.y, gravityVector.z};
    double angle = getAngleBetweenPlanes(pair.planeModel, gravity);
    Log.d(TAG, "angle: " + angle);
    if (angle < 0.1) {
        return false;
    }
    return true;
}

/**
 * Calculates the angle between two planes according to http://mathworld.wolfram
 * .com/DihedralAngle.html
 */
private double getAngleBetweenPlanes(double[] a, double[] b) {
    double numerator = Math.abs(a[0] * b[0] + a[1] * b[1] + a[2] * b[2]);
    double aFactor = Math.sqrt(a[0] * a[0] + a[1] * a[1] + a[2] * a[2]);
    double bFactor = Math.sqrt(b[0] * b[0] + b[1] * b[1] + b[2] * b[2]);
    double denumerator = aFactor * bFactor;
    double result = Math.acos(numerator / denumerator);
    return result;
}