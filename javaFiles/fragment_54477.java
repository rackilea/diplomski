public class Bicycle{ 
    int gear;
    int cadence;
    int speed;
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear; 
        cadence = startCadence; 
        speed = startSpeed; } 
    public static void main(String[] args){ 
        Bicycle myBike = new Bicycle(30, 0, 8); 
        int current_gear = myBike.gear; }
}