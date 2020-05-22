@Entity
public class Person Address {

  @ManyToOne
  @MapsId("personId")
  @JoinColumn(name = "person_id", nullable = false, updatable = false)
  private RelatedParty relatedParty;

  @EmbeddedId
  @JsonIgnore
  private RelatedPartyAddressId id;

  @ManyToOne
  @MapsId("addressId")
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

}