private boolean isAlignedWithGravity(IntersectionPointPlaneModelPair candidate,
                                         TangoPoseData devicePose, double maxDeviation) {
    Matrix4 adfTdevice = ScenePoseCalculator.tangoPoseToMatrix(devicePose);
    Vector3 gravityVector = ScenePoseCalculator.TANGO_WORLD_UP.clone();
    adfTdevice.clone().multiply(mExtrinsics.getDeviceTDepthCamera()).inverse().
            rotateVector(gravityVector);

    double[] gravity = new double[]{gravityVector.x, gravityVector.y, gravityVector.z};
    double angle = VectorUtilities.getAngleBetweenVectors(candidate.planeModel, gravity);
    // vectors should be perpendicular => 90° => PI / 2 in radians
    double target = Math.PI / 2; 
    return (Math.abs(target - angle) <= maxDeviation);
}