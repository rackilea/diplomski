class team implements Comparable<team> {
    public int teamNum;
    public int points = 0;
    public team(int x) {
       this.teamNum = x;
    }
    public team(int x,int y) {
        this.teamNum = x;
        this.points = y;
    }

    public int compareTo(team t1){
     return t1.points - this.points;
    }
}