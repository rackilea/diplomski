public boolean europeanequals(){
    for (int i = 0; i < anyplayer.length; i++) {
        if (roulettedriver.eurowinningnumber == anyplayer[i]) {
            return true;
        }
    }
    return false;
}