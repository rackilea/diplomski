double[] calcRanges(List<Product> sortedProducts, int count){
    double result = new double[count + 1];
    result[0] = 0;
    for(int i = 1; i < result.length; i++) {
        int pos = (sortedProducts.getSize() * i) / count;
        result[i] = sortedProducts.get(pos).getPrice();
    }
}