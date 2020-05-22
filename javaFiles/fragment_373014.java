public boolean doesExist(String buttonValue) {
    for (int a = 0 ; a < seats.size() ; a++){
        if (buttonValue.equalsIgnoreCase(seats.get(a))){
            seats.remove(seats.get(a));
            return true;
        }
    }
    return false;
}