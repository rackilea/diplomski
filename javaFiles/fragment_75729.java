public Produs getProdus(Produs p)
{
    for(Produs prod:produse)
    {
        if ((prod.getDenumire().equals(p.getDenumire()) && (prod.getTaraOrigine().equals(p.getTaraOrigine()))));
        {
            if (prod.getCategorie() == null) {
                prod.setCategorie(p.getCategorie());//assuming you have getter and setter already in Produs
            }
            return prod;//remove this statement, if you want multiple products to be updated and make this method as void type instead of returning Produs type. Remove return null as well from end of this method.
        }
    }
    return null;
}