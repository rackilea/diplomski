public Time addMinutes(int mins) {
    this.mins += mins;
    if (this.mins >= 60) {  // check if over
        addHours(this.mins / 60);
        this.mins = this.mins % 60;
    }
    return this;
}