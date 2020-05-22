public void getProdus(Produs p)
{
    List<Produs> productList = new ArrayList<Produs>();
    for(Produs prod:produse)
    {
        if ((prod.getDenumire().equals(p.getDenumire()) && (prod.getTaraOrigine().equals(p.getTaraOrigine()))));
        {
            productList.add(prod);
        }
    }
    for(Produs prod:productList) {//iterate over the list who matched the criteria and amend it with properties from p.
    }
}