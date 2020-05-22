public LinkedList<Object[][]> addMatrices()
{
    LinkedList<Object[][]> l=new LinkedList<>();
    Object[][] o=new Object[2][2];
    o[0][0]=new Empty(2);
    o[0][1]=new Other();    
    o[1][0]=new Empty(4);
    o[1][1]=new Empty(6);
    l.add(o);

    Object[][] o2=new Object[2][2];
    o2[0][0]=new Empty(4);
    o2[0][1]=new Other();    
    o2[1][0]=new Empty(5);
    o2[1][1]=new Empty(1);
    l.add(o2);

    for(Object[][] oo:l)
    {

       for(int x=0;x<oo.length;x++){
           for(int y=0;y<oo[x].length;y++) {
               System.out.print("\t"+oo[x][y]+" ");
               System.out.print("\t|");}
               System.out.println(System.lineSeparator());
           }
           System.out.println(System.lineSeparator());
       }
    return l;
}