@Override
public Product getProduct(int productId)
{
    Iterator<Product> pritr = products.iterator();
    while (pritr.hasNext())
    {
        Product pr = pritr.next();
        if (pritr.next().getId() == productId)
        {
            return pr;
        }
    }
    return null;
}