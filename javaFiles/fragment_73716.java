public class BusinessEntity implements Serializable
{
    //for simplicity, here just the important part
    private String s;

    @ManyToOne(fetch= FetchType.LAZY )
    private ImportantEntity anotherEntity;

    private String anotherEntityName;

    @Override
    public boolean equals( Object obj )
    {
        if(BusinessEntity.class.isAssignableFrom(obj.getClasS())){  
         BusinessEntity other =  (BusinessEntity)obj;
         return other.anotherEntityName.
                equals(this.anotherEntityName) && 
                other.s.equals(this.s);

        }
       return true;
    }
    public void setAnotherEntity(ImportantEntity ie){
        anotherEntityName= ie.getName();
        anotherEntity = ie;
    }
}