while (!ok) {
    System.out.print("\n name: ");


    kg.setName(io.readString()); 

    k.add(kg); // add here the element

    if (argu_vali.analyse(k, "mylist") == 0) {
        ok = true;

    }
    k.remove(k.getList().size()-1); //delete the element and go on with validation
}