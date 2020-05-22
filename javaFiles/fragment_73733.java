@Embeddable
public class AllocationKey implements Serializable {

   PriceRequestLegKey legKey; // corresponds to PK type of PriceRequestLegModel
   @Column(name = "allocation_index")
   private int allocationIndex;
   ...
}