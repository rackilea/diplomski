public class PersoonBag {
    private int id;
    private String naam;
    private String voornaam;
    private Date geboortedatum;
    private String opmerking;
    private boolean isTrainer;
    private PloegBag ploeg;

    public PersoonBag(int id, String naam, String voornaam, Date geboortedatum, String opmerking,boolean isTrainer, PloegBag ploeg){
       this.id=id;
       this.naam=naam;
       this.voornaam=voornaam;
       this.geboortedatum=geboortedatum;
       this.opmerking=opmerking;
       this.isTrainer=isTrainer;
       this.ploeg=ploeg;
    }

    public PersoonBag()
    {
    }

    public PloegBag getPloeg() {
        return ploeg ;
    }

    public void setPloeg(PloegBag ploeg) {
        this.ploeg = ploeg ;
    }

    // other get/set methods ...

}