ListIterator<Product> iter = StockProducts.listIterator();
while(iter.hasNext()){
    if(iter.next().equals(p)){
        iter.remove(p);
    }
}