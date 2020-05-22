@Entity
@Table(name="orderitem")
public class orderitem 
{
   @EmbeddedId
   private orderitem_PK PK; //composite key

   @ManyToOne
   @MapsId("oid") // maps the order id attribute of embedded id
   @JoinColumn(name="oid", referencedColumnName="oid" ,insertable = false, updatable = false)
   private order order;

   @ManyToOne
   @MapsId("pid") // maps the product id attribute of embedded id
   @JoinColumn(name="pid", referencedColumnName="pid", insertable = false, updatable = false)
   private product products ;

   ////
   setter,getter and other
}