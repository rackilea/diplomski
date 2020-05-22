import lejos.nxt.*;

public class test {
    public static void main(String [] args) throws InterruptedException {
        UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S1);
        for (int i = 0; i < 5; i++) {

            // No initial motor movement (because it did nothing anyway)

            // We change this to approach from either direction.
            while (ultra.getDistance() != 30) {
                // Check whether it's behind or ahead of it.
                // Assuming that B- and C- increase distance, and B+ and C+ decrease it (depends on robot configuration).
                // This is called a feedback loop, by the way.
                if (ultra.getDistance() < 30) { // Move forward (distance+)
                    Motor.B.backward();
                    Motor.C.backward();
                } else { // Move backward (distance-)
                    Motor.B.forward();
                    Motor.C.forward();
                }
            }

            // We only get here when the distance is right, so stop the motors.
            Motor.B.stop();
            Motor.C.stop();               

            LCD.clear();
            LCD.drawString("Distance : "+ultra.getDistance(), 0, 0);
        }
        Button.waitForAnyPress();
    }
}