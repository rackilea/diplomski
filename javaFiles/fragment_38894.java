public Aandeel(String code, String naam, double dividend, double[] tab)
{
    this.code = code;
    this.naam = naam;
    setDividend(dividend);
    waarden = new double[tab.length];
    setWaarden(tab);
}

public void setWaarden( double[] tab)
{
    for (int i = 0; i<tab.length; i++)
    {
         waarden[i] = tab[i]
    }
}