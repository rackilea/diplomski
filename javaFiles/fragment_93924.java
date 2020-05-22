String[] toDelete = request.getParameterValues("toDelete[]");
    int[] toBeDeleted=new int[toDelete.length];
    for(int i=0;i<toDelete.length;i++)
    {
        toBeDeleted[i]=Integer.parseInt(toDelete[i]);
    }