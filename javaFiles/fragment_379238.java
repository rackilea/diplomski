public class ClockDisplay {

        //...

        /**
         * This method should get called once every minute - it makes the clock
         * display go one minute forward.
         */
        public void timeTick() {
            if (minutes.increment()) {  // on clock at after 12 am or pm.
                hours.increment(); // after 60 mins, next per hour.
            }
            updateDisplay(); // updating to return 
        }

        //...

}