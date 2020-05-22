if(myList instanceof LinkedHashSet)
        System.out.println("Hash Set contains : " + myList + " ......order based on Hashing");
    else if(myList instanceof HashSet)
        System.out.println("Linked List contains : " + myList + " ......In inserted order.");
    else if(myList instanceof TreeSet)
        System.out.println("Tree Set contains : " + myList + " ......Ascending order.");