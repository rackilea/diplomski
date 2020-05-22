@JsonProperty(value = "defaultaddressid")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = true) 
public AddressInformation getDefaultAddress() {
    return defaultAddress;
}