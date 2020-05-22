package sample;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import sample.Interpretater;

public class MyFirstRobot extends Robot {

    Interpretater inter;

    public void run() {
        inter = new Interpretator(this); // intel looked like a typo
        while (true) {
            ahead(50); // Move ahead 100
            // turnGunRight(360); // Spin gun around
            back(50); // Move back 100
            // turnGunRight(360); // Spin gun around
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        /*
         * If I write fire() here, it will work, but I want to call it from some
         * other class (intel)
         */
        inter.onScan();
    }

    public void onHitByBullet(HitByBulletEvent e) {
        turnLeft(90 - e.getBearing());
    }
}