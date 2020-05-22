public void advance(int aminutes) {
    minutes = minutes + aminutes;
    if (minutes > 59) {
        int moreHours = Math.round(minutes / 60);
        minutes = minutes % 60;
        hours += moreHours;
    }
}