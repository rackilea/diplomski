ListIterator<Product> iter = StockProducts.listIterator();
while(iter.hasNext()){
    if(iter.next().getCode() == p.getCode()){
        iter.remove(p);
    }
}