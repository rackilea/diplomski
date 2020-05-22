public class Vehicle {
    private int id;
    public String brand;
    public String type;
    public DateTime entryTimeDate;

    public Vehicle()
    {
        setId(0);
        setBrand("");
        setType("");
        setEntryTimeDate(new DateTime("DATE", "TIME"));
    }

    public Vehicle(int id, String brand, String type, DateTime entryTimeDate) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.entryTimeDate = entryTimeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateTime getEntryTimeDate() {
        return entryTimeDate;
    }

    public void setEntryTimeDate(DateTime entryTimeDate) {
        this.entryTimeDate = entryTimeDate;
    }

    public static class DateTime{
        private String date;
        private String time;

        public DateTime(String date,String time) {
            this.setDate(date);
            this.setTime(time);

        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.getEntryTimeDate().setTime("Time of the vehicle");
        v1.getEntryTimeDate().setDate("Date of the vehicle.");
    }
}