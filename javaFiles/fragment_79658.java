public class Copil extends Parinte {
    int varsta;
    Copil(String nume, String prenume, String cnp, String domiciliu, int varsta){
        super(nume,prenume,cnp,domiciliu);
        this.varsta=varsta;
    }

    @Override
    public String toString() {
        return "Copil. Nume" + nume + " Varsta: " + varsta;  //Whatever you want to do here
    }

}