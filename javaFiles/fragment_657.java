public void union(int p, int q) {
    validate(p);
    validate(q);
    int pID = id[p];   // needed for correctness
    int qID = id[q];   // to reduce the number of array accesses

    // p and q are already in the same component
    if (pID == qID)

        return;

    StringBuilder sb=new StringBuilder("");  

    for (int i = 0; i < id.length; i++)
    {
        sb.append(id[i]) + " "; // you are accessing all id elements anyway; add it to the 'sb' string while you are at it
                                // seperate each id element with a space
                                // do it in this place (before the if statement below) if you would like to print the before state of the array

        if (id[i] == pID) 
            id[i] = qID;

        //sb.append(id[i]) + " ";  // do it here if you would like to print the after state of the array

    }

    System.out.println(sb);
    count--;

}