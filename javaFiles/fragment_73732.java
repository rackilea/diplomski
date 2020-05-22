@Entity(name = "PriceRequestLeg")
public class PriceRequestLegModel {

   @EmbeddedId
   private PriceRequestLegKey legKey;
   @OneToMany(mappedBy="leg", cascade = CascadeType.ALL)
   private List<AllocationModel> allocations;
   ...
}