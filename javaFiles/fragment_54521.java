public void tick(){
    sec++;
    if (sec >= 60){
        min++;
        sec = sec - 60;
    }
    if (min >= 60){
        hrs++;
        min = min - 60;
    }
}