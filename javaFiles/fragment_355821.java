public boolean europeanequals(){
    for (int number : anyplayer) {
        if (roulettedriver.eurowinningnumber == number) {
            return true;
        }
    }
    return false;
}