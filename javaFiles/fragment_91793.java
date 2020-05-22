@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "profileType", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ClientDto.class, name = "CLIENT"),
    @JsonSubTypes.Type(value = OwnerDto.class, name = "OWNER")
})
public class UserDTO {
 .....
}