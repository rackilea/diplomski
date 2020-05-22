class Fact{

    private ArrayList<ParagraphText> paraTexts;
    private String text;        
    //any other attributes

    public Fact(){
        //initialization..
    }

    public void addParaText(ParagraphText p){
        paraTexts.add(p);
        p.linkWithFact(this);  //remember which fact p belongs to
    }

    public void removeParaText(ParagraphText p){
        if(paraTexts.contains(p)){
            p.unlinkFact();
            paraTexts.remove(p);
        }
    }
}