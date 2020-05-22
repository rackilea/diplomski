public class DataToUse {
        @SerializedName("@name")
        private String name;
        @SerializedName("@date")
        private Date date;

        public String getName() { return this.name; }
        public void setName(String name) { this.name = name; }

        public Date getDate() { return this.date; }
        public void setDate(Date date) { this.date = date; }
    }