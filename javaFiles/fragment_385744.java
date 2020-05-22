boolean found = false;
    for(int u = 0; u < myA.length; u++){
        if(myA[u] == toS){
            System.out.println("Item found" );
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Item not in list");
        break;
    }