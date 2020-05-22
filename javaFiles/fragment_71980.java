public class Parking {

    public static void main(String[] args) {
        //PoliceOfficer po = new PoliceOfficer("John Policeman", "4599BDG");
        ParkedCar pc = new ParkedCar("Lexus", "IS250", "White", "7GHK111", 90);
        ParkingMeter pm = new ParkingMeter(2, 30);
        PoliceOfficer.checkTheCar(pc, pm);
    }

    public static class ParkingMeter {

        private int time, hours, minutes;

        public ParkingMeter(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
            setTime(hours, minutes);
        }

        private void setTime(int hours, int minutes) {
            this.time = (hours * 60) + minutes;
        }
        public int getTime() {
            return time;
        }

        public int getHours() {
            return hours;
        }
        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }
        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

    }

    public static class ParkedCar {

        private String make; // Company name
        private String model; // Car model
        private String color; // Car color
        private String plateNum; // License plate number
        private int minutes; // number of minutes parked

        public ParkedCar(String make, String model, String color,
            String plate, int minutes) {
            this.make = make;
            this.model = model;
            this.color = color;
            this.plateNum = plate;
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return color + " " + make + " " + model + ", plateNum=" + plateNum + " ";
        }

    }

    public static class PoliceOfficer {
        private String officerName;
        private String badgeNumber;

        public PoliceOfficer(String name, String badge) {
            this.officerName = name;
            this.badgeNumber = badge;
        }

        public String getOfficerName() {
            return officerName;
        }

        public void setOfficerName(String officerName) {
            this.officerName = officerName;
        }

        public String getBadgeNumber() {
            return badgeNumber;
        }

        public void setBadgeNumber(String badgeNumber) {
            this.badgeNumber = badgeNumber;
        }

        public static void checkTheCar(ParkedCar pc, ParkingMeter pm) {
            System.out.println(pc.toString() + " has been parked for : " + pm.getTime() + " minutes");
        }
    }

}