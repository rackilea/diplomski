private void startMotionSensor() {
    platform.startMotionSensors(new PlatformCallback<float[]>() {
        @Override
        protected void doCallback(Result result, float[] rotationMatrix) {
            if (result.ok()) {
                // Do what you want with the rotation matrix
            }
        }
    });
}

public void stopMotionSensor() {
    platform.stopMotionSensors();
}