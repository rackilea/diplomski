public static double[] profits(ArrayList<MenuItem> items)
{
    double[] lol = new double[items.size()];
    int i = 0;
    for (MenuItem z : items)
    {
        lol[i] = roundMoney(z.getPrice() - z.getCost());
        i++;
    }
    return lol;
}