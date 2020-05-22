@Value.Immutable
@Value.Style(defaults = @Value.Immutable(copy = false), init = "set*")
@JsonSersonIgnoreialize(as = ImmutableUserDto.class)
@JsonDeserialize(builder = ImmutableUserDto.Builder.class)
public abstract class UserDto {

    ....

    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    public abstract String getPassword();
}