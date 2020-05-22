TangoSupport.TangoMatrixTransformData transform =
                        TangoSupport.getMatrixTransformAtTime(pointCloud.timestamp,
                                TangoPoseData.COORDINATE_FRAME_START_OF_SERVICE,
                                TangoPoseData.COORDINATE_FRAME_CAMERA_DEPTH,
                                TangoSupport.TANGO_SUPPORT_ENGINE_OPENGL,
                                TangoSupport.TANGO_SUPPORT_ENGINE_TANGO,
                                TangoSupport.ROTATION_IGNORED);

if (transform.statusCode == TangoPoseData.POSE_VALID) {
    int numPoints = pointCloud.numPoints;
    Vector3 point = new Vector3(0f, 0f, 0f);

    double dTransformMatrix[] = new double[transform.matrix.length];

    for (int k = 0; k < transform.matrix.length; k++) {
        dTransformMatrix[k] = (double) transform.matrix[k];
    }

    if (numPoints != 0) {
        int numFloats = 4 * numPoints;
        for (int j = 0; j < numFloats; j = j + 4) {
             if (pointCloud.points.get(j + 3) >= 0.5) {
                 point.x = pointCloud.points.get(j);
                 point.y = pointCloud.points.get(j + 1);
                 point.z = pointCloud.points.get(j + 2);
                 point = point.multiply(dTransformMatrix);
                 myOutWriter.write(String.format("v %f %f %f\n", point.x, point.y, point.z));
             }
         }
     }
}