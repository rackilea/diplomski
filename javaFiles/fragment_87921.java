public class Preferences {

        private Preferences(){}

        public static Preferences set() {
            return new Preferences();    
        }

        public Preferences background(Color color) {
            //set color on real preferences
            return this;
        }

        public Preferences border(Color color) {
            //set color on real preferences
            return this;
        }

    }