@Override
    public Personne clone()
{
    Personne o;
    try {
       o = (Personne)super.clone();
       o.adresse = null;
       return o;
    } catch(CloneNotSupportedException cnse) {
      cnse.printStackTrace(System.err);
      throw new RuntimeException();
    }
}
 // setter pour l adresse du Clone :
    public void setAdresseClone(Adresse a){
    this.clone().adresse = a;
    }