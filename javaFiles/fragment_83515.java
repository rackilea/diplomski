boolean Chance(double percentage) {
    double a = Math.random();
    if(a <= percentage) {
        return true;
    }else {return false;}

}