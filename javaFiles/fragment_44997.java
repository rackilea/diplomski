List<Lid> lids = new ArrayList<>();
for(Persoon persoon : personen){
    if(persoon instanceof Lid){
        // safe cast and add to lids
        lids.add((Lid) persoon);
    }
}