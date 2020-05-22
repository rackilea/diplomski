@Entity(name = "Allocation")
public class AllocationModel {

   @EmbeddedId
   private AllocationKey allocationKey;
   @ManyToOne
   @MapsId("legKey")
   @JoinColumns({
      @JoinColumn(name = "leg_request_id", referencedColumnName = "leg_request_id"),
      @JoinColumn(name = "display_index", referencedColumnName = "display_index")
   })
   private PriceRequestLegModel leg;
   ...
}