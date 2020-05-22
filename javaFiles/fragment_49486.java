class Factory {    

    private Action run;
    private Action climb

    public Factory() {                       
        run = new RunAction();
        climb = new ClimbAction();
    }

    public Action getRunAction(){ return run; }
    public Action getClimbAction(){ return climb; }
}