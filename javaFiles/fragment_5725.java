boolean continueBool= true;
 double lastValue=0;
 double leftDist = distanceSensorLeft.getDistance(DistanceUnit.MM);
 double rightDist = distanceSensorRight.getDistance(DistanceUnit.MM);
 leftDrive.setTargetPosition(leftDrive.getCurrentPosition() - 1500);
 rightDrive.setTargetPosition(rightDrive.getCurrentPosition() + 1500);
 leftDrive.setPower(0.2);
 rightDrive.setPower(-0.2);

 while (continueBool) {
        if(lastValue<=actualValue){
        continueBool=false;
    }

        lastValue=actualValue;

}