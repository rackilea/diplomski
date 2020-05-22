public class ProductRatingSort implements Comparator<Product> {

@Override
public int compare(Product arg0, Product arg1) {
    // TODO Auto-generated method stub
    int f = arg0.getProductRating();
    int s = arg1.getProductRating();

      if(f>s)
       return 1;
    return -1;
}
}