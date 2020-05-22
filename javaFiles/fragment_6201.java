public int getScore(Sale sale, Product product) {
    int count = 0;
    if (this.getValue1() == sale.getValue1()) count++;
    //...
    return count;
}