class ParagraphText{

    private int startPos;
    private int endPos;
    private Fact fact;
    //any other attributes

    public ParagraphText(int startPos, int endPos){
        this.startPos = startPos;
        this.endPos = endPos;
        //any other initializations
    }

    public void linkWithFact(Fact fact){
        this.fact = fact;
    }

    public void unlinkFact(){
        this.fact = null;
    }
}