public BFS() {
    this.start = start;  //  Variable 'start' is assigned to itself 
    this.goal = goal;    //  Variable 'goal' is assigned to itself 

    addToOpenList(start, null);   // start is null
}