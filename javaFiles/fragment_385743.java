if(myA[u] == toS){
            System.out.println("Item found" );
            break;
        }
        if(myA[u] != toS){
            continue;
        }
        else{ // myA[u] == toS - never happens, since previous if statement broke from the loop
            System.out.println("Item not in list");
            break;
        }