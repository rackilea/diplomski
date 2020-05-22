boolean success = SensorManager.getRotationMatrix(
   matrixR,
   matrixI,
   valuesAccelerometer,
   valuesMagneticField);

if(success){
SensorManager.getOrientation(matrixR, matrixValues);

double azimuth = Math.toDegrees(matrixValues[0]);
double pitch = Math.toDegrees(matrixValues[1]);
double roll = Math.toDegrees(matrixValues[2]);

readingAzimuth.setText("Azimuth: " + String.valueOf(azimuth));
readingPitch.setText("Pitch: " + String.valueOf(pitch));
readingRoll.setText("Roll: "+String.valueOf(roll));