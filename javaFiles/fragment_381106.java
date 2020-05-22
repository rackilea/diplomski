public class Poo {

    public Poo(Po po, PoPart poPart, Part part) {
        super();
        this.po = po;
        this.poPart = poPart;
        this.part = part;
    }

    Po po;

    PoPart poPart;

    Part part;

    public Po getPo() {
        return po;
    }

    public void setPo(Po po) {
        this.po = po;
    }

    public PoPart getPoPart() {
        return poPart;
    }

    public void setPoPart(PoPart poPart) {
        this.poPart = poPart;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

}