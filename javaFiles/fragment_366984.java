public VerzekeringBeheer() {
    ...
    //verzekeringmaatschappijLijst is never initialized!!!
}

public void maakLijstAan() 
{
    verzekeringmaatschappijLijst = new Lijst<>();
    System.out.println("Maak lijst aan");
}

public Object[] getMaatschappijNamen() 
{
    ArrayList<String> mnamen = new ArrayList<String>();
    // Here you use verzekeringmaatschappijLijst without checking that is not null!!!
    for (VerzekeringsMaatschappij maatschappij : verzekeringmaatschappijLijst) 
    {
        mnamen.add(maatschappij.getMaatschappijNaam());
    }
    return mnamen.toArray();
}