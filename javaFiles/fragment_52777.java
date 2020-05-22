public class House {

    //these are immutable if you wish
    private final int mNumberOfWindows;
    private final int mNumberOfDoors;

    private House(HouseBuilder builder) {
        mNumberOfWindows = builder.mNumberOfWindows;
        mNumberOfDoors = builder.mNumberOfDoors;
    }

    public static class HouseBuilder {
        private int mNumberOfWindows; //set defaults here, make final and pass in builder constructor if they must be set
        private int mNumberOfDoors;

        public HouseBuilder windows(int numberOfWindows) {
            mNumberOfWindows = numberOfWindows;
            return this;
        }

        public HouseBuilder doors(int numberODoors) {
            mNumberOfDoors = numberODoors;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    public int getNumberOfWindows() {
        return mNumberOfWindows;
    }

    public int getNumberOfDoors() {
        return mNumberOfDoors;
    }
}