public static double toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        else {
            // you don't need to check if kilometersPerHour is 0, since every number multiplied with 0 is 0
            return kilometersPerHour * 1.609;
        }
    }