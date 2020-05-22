while(rss.next()){
    update_del_insert_products product = new Update_del_insert_products();
    int i = 1
    product.setPro_ID(rss.getString(Pro_ID, i++));
    product.setPro_Name(rss.getString(Pro_Name, i++));
    ...

    prolist.add(product);
}