for(Order o1:labels){
    if(product.equals(o1.getProduct())){ //collect all the object with the same product name in a temporary list.
        temp.add(o1); 
    }
}

for(Order lb:temp){ //iterate the list and get the version of each element
    versions.add(lb.getVersion());               
}