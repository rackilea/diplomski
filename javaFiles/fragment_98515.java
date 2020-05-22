for(int j=doc.getNumberOfPages()-1; j >= 0; j--){
    if(i!=j)
    {
        doc.removePage(j);                
    }
}