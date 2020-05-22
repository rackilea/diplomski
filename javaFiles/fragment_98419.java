public List<Product> GetTopRelatedProductsD(int N)
{
    var relatedSet = new HashSet<Product>();
    Action<Product> GetRelatedProducts = null;
    GetRelatedProducts = product =>
    {
        if (product.RelatedProducts == null) return;
        foreach (var item in product.RelatedProducts)
            if (item != this && relatedSet.Add(item))
                GetRelatedProducts(item);
    };
    GetRelatedProducts(this);
    return relatedSet.OrderByDescending(x => x.Rating).Take(N).ToList();
}