// globals
private float[] gravityData = new float[3];
private float[] geomagneticData  = new float[3];
private boolean hasGravityData = false;
private boolean hasGeomagneticData = false;
private double rotationInDegrees;


@Override
public void onSensorChanged(SensorEvent event) {
    switch (event.sensor.getType()){
        case Sensor.TYPE_ACCELEROMETER:
            System.arraycopy(event.values, 0, gravityData, 0, 3);
            hasGravityData = true;
            break;
        case Sensor.TYPE_MAGNETIC_FIELD:
            System.arraycopy(event.values, 0, geomagneticData, 0, 3);
            hasGeomagneticData = true;
            break;
        default:
            return;
    }

    if (hasGravityData && hasGeomagneticData) {
        float identityMatrix[] = new float[9];
        float rotationMatrix[] = new float[9];
        boolean success = SensorManager.getRotationMatrix(rotationMatrix, identityMatrix,
            gravityData, geomagneticData);

        if (success) {
            float orientationMatrix[] = new float[3];
            SensorManager.getOrientation(rotationMatrix, orientationMatrix);
            float rotationInRadians = orientationMatrix[0];
            rotationInDegrees = Math.toDegrees(rotationInRadians);

            // do something with the rotation in degrees
        }
    }
}