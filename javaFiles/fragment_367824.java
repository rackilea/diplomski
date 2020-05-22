public void updateProduct(Product product) throws ProductNotFoundException 
{
    // TODO Auto-generated method stub
    Iterator<Product> pritr = products.iterator();
    boolean match = true;
    while(pritr.hasNext())
    {
        Product pr = pritr.next();
        if (pr.getId().equals(product.getId()))
        {

            pritr.remove();

        }
        else
        {
            match = false;
        }

    }
    if (match == false)
    {
        new ProductNotFoundException("Product not found");
    }
    else
    {
        products.add(product);
    }


}