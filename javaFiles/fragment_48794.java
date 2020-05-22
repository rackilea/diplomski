public class Automobile {

        private int year;
        private int color;
        private int brand;

        //add other fields

        public Automobile (int brand, int year, int color, boolean automatic, double kilometers,int nbrDoors, String description, boolean sold) {

            if (year >= YEAR_MIN && year <= YEAR_MAX)  {
                this.year = year;
            } else {
                new IllegalArgumentException("Invalid Year Passed to construct Automobile");
            }

            //Similarly add other validations for brand, color, etc..
        }

        public void setYear ( int year ) {
            if (year >= YEAR_MIN && YEAR <= YEAR_MAX) {
                //USE 'this.' as shown below' to set the given year to 'this' object's year
                this.year = year;
            }
        } 

       public int getYear() {
           return year;
       }

        //Similarly add setters and getters for year, color, brand, etc...
}