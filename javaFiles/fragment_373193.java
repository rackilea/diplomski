for (int i = 1; i < authors.length; i++) {
    if(i == authors.length - 1)
        System.out.print("& " + authors[i]);
    else
        System.out.print("; " + authors[i]);
 }