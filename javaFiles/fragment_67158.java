public void infoListe(){
    if(ansat != null) {
        ansat.add(new Ansat("Hej", 123, ansat));
    } else {
        ansat = new ArrayList<Ansat>();
        ansat.add(new Ansat("Hej", 123, ansat));
    }
}