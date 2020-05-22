public boolean addItem(CartItem item) {
    boolean flag = false;
    for (CartItem itm : this.itemList) {
        if (itm.isSameProduct(item)) {
            itm.setQnty(item.getQnty() + itm.getQnty());
            flag = true;
            break;
        }
    }
    if (!flag) {
        this.itemList.add(item);
        flag = true;
    }
    return flag;
}