public static final double  zeroRad         = Math.toRadians(0);
public static final double  ninetyRad       = Math.toRadians(90);
public static final double  oneEightyRad    = Math.toRadians(180);
public static final double  twoSeventyRad   = Math.toRadians(270);

public static final strictfp void updateLookVectorsIn6DoF(Vector3f yawPitchAndRoll, Vector3f forward, Vector3f up, Vector3f right) {
    final double yaw = Math.toRadians(yawPitchAndRoll.getX());
    final double pitch = Math.toRadians(yawPitchAndRoll.getY());
    final double roll = Math.toRadians(yawPitchAndRoll.getZ());

    final float sinYaw = ((float) Math.sin(yaw));
    final float cosYaw = ((float) Math.cos(yaw));

    final float sinYaw90 = ((float) Math.sin(yaw + ninetyRad));
    final float sinYaw270 = ((float) Math.sin(yaw - ninetyRad));//+ twoSeventyRad));
    final float cosYaw90 = ((float) Math.cos(yaw + ninetyRad));
    final float cosYaw180 = ((float) Math.cos(yaw + oneEightyRad));
    final float cosYaw270 = ((float) Math.cos(yaw - ninetyRad));//+ twoSeventyRad));

    final float sinRoll = ((float) Math.sin(roll));
    final float cosRoll = ((float) Math.cos(roll));
    final float cosRoll180 = ((float) Math.cos(roll + oneEightyRad));

    final float cosPitch90 = ((float) Math.cos(pitch + ninetyRad));
    final float sinPitch90 = ((float) Math.sin(pitch + ninetyRad));
    final float sinPitch270 = ((float) Math.sin(pitch - ninetyRad));

    //Forward:(No roll because roll goes around the Z axis and forward movement is in that axis.)
    float x = sinYaw * ((float) Math.cos(pitch));
    float y = -((float) Math.sin(pitch));
    float z = cosYaw * ((float) Math.cos(pitch - oneEightyRad));
    forward.set(x, y, z);

    //Multiply in this order: roll, pitch, yaw
    //cos(90) = 0, cos(180) = -1, cos(270) = 0, cos(0) = 1
    //sin(90) = 1, sin(180) = 0, sin(270) = -1, sin(0) = 0

    //hmm... gimbal lock, eh? No!

    //Up://
    x = (cosRoll180 * cosPitch90 * sinYaw) - (sinRoll * cosYaw180);
    y = -sinPitch270 * cosRoll;
    z = (cosRoll * cosPitch90 * cosYaw) + (sinRoll * sinYaw);
    up.set(x, y, z);
    //Right:
    x = (cosRoll * sinYaw90) - (sinRoll * cosPitch90 * cosYaw90);
    y = 0 - (sinRoll * sinPitch90);//This axis works fine
    z = (cosRoll * cosYaw270) + (sinRoll * cosPitch90 * sinYaw270);
    right.set(x, y, z);
}