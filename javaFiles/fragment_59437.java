boolean found = false;
for(Item item : items) {
    if(item.checkCode(inputCode)){
        found = true;
        [...] // Here you found the item and you can check the price and other stuff
    }
}
if(!found) {
    [...] // Here you can handle the case of the incorrect code
}