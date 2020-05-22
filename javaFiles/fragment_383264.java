public boolean parrotTrouble(boolean talking, int hour) {
    if (hour < 7 || hour > 20) {
        if (talking) {
            return true;
        } else {
            return false;
        }
    } else
        return false;
}