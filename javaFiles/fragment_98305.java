boolean foundIt = false;
for (Produto p2 : listItems) {
    //Verify if has a product in list with the same name
    if (p2.getName().equalsIgnoreCase(p.getName())) {
        //increase the product quantity
        p2.setQuantity((int) (p2.getQuantity() + 1));
        foundIt = true;
        break;
    }
}
if (!foundIt) {
    listItems.add(p);
}