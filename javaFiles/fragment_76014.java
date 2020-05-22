Query qr=s.createQuery("from Class_2 where ID= :f and code= :j order by mark desc");

for( Class_1 a : class1list ) 
{
    qr.setParameter( "f", a.id );
    qr.setParameter( "j", a.code );

    for( Class_2 cls: qr.list() )
    {
        modelclass mdl=new modelclass(cls.getID(),cls.getCode(),cls.getMark());
        mdlclasslist.add(mdl);
    }
}